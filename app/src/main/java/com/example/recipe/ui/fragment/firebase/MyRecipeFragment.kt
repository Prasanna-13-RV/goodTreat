package com.example.recipe.ui.fragment.firebase

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.R
import com.example.recipe.data.entity.MyRecipeEntity
import com.example.recipe.databinding.FragmentMyRecipeBinding
import com.example.recipe.databinding.FragmentShowRecipesBinding
import com.example.recipe.ui.adapter.MyRecipeAdapter
import com.example.recipe.viewmodel.RecipeViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import kotlinx.coroutines.DelicateCoroutinesApi

class MyRecipeFragment : Fragment() {
    private lateinit var binding: FragmentMyRecipeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: RecipeViewModel
    private lateinit var recipeAdapter: MyRecipeAdapter
    private val db = Firebase.firestore
    private val TAG = "MyRecipeFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentMyRecipeBinding.inflate(inflater, container, false)

        recyclerView = binding.recipeRecyclerView

        viewModel = ViewModelProvider(requireActivity())[RecipeViewModel::class.java]

        viewModel.getAllRecipes()

//        Floating Button
        binding.floatingActionButton.setOnClickListener {
//            it.findNavController().navigate(R.id.action_myRecipeFragment_to_addRecipeFragment)
            replaceFragment(AddRecipeFragment())
        }

        val myArrayList = mutableListOf<MyRecipeEntity>()
        db.collection("recipes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result.documents) {
                    Log.d(TAG + "result", result.toString())
                    val data = document.toObject<MyRecipeEntity>()
                    if (data != null) {
                        myArrayList.add(data)
                    }
                    Log.w(TAG, "$myArrayList")
                }
                Log.w(TAG + "my message", "$myArrayList")

                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = MyRecipeAdapter(myArrayList)

                recipeAdapter = MyRecipeAdapter(myArrayList)
                recyclerView.adapter = recipeAdapter

                recipeAdapter.onItemClick = {
                    val bundle = Bundle()
                    bundle.putString("data", Gson().toJson(it))
                    val dashboardFragment = MySingleRecipeFragment()
                    dashboardFragment.arguments = bundle
                    val transaction = parentFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, dashboardFragment)
                    transaction.addToBackStack(null) // Add to the back stack
                    transaction.commit()

//                parentFragmentManager.beginTransaction().apply {
//                    replace(R.id.fragmentContainerView, dashboardFragment)
//                    commit()
//                }
                }

            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

//        viewModel.myRecipes.observe(viewLifecycleOwner, Observer { recipes ->
////            Log.d("myAppCurrent", recipes.toString())
//
//            recyclerView.layoutManager = LinearLayoutManager(context)
//            recyclerView.adapter = MyRecipeAdapter(recipes)
//
//            recipeAdapter = MyRecipeAdapter(recipes)
//            recyclerView.adapter = recipeAdapter
//
//            recipeAdapter.onItemClick = {
//                val bundle = Bundle()
//                bundle.putString("data", Gson().toJson(it))
//                val dashboardFragment = SingleRecipeFragment()
//                dashboardFragment.arguments = bundle
//                val transaction = parentFragmentManager.beginTransaction()
//                transaction.replace(R.id.fragmentContainerView, dashboardFragment)
//                transaction.addToBackStack(null) // Add to the back stack
//                transaction.commit()
//
////                parentFragmentManager.beginTransaction().apply {
////                    replace(R.id.fragmentContainerView, dashboardFragment)
////                    commit()
////                }
//            }
//        })

        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }

}