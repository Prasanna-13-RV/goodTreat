package com.example.recipe.ui.fragment.remote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.R
import com.example.recipe.databinding.FragmentShowRecipesBinding
import com.example.recipe.ui.adapter.RecipeShowAdapter
import com.example.recipe.viewmodel.RecipeViewModel
import com.google.gson.Gson

class ShowRecipesFragment : Fragment() {
    private lateinit var binding: FragmentShowRecipesBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: RecipeViewModel
    private lateinit var recipeAdapter: RecipeShowAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentShowRecipesBinding.inflate(inflater, container, false)

        recyclerView = binding.recipeRecyclerView

        viewModel = ViewModelProvider(requireActivity())[RecipeViewModel::class.java]

        viewModel.getAllRecipes()

        viewModel.myRecipes.observe(viewLifecycleOwner) { recipes ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = RecipeShowAdapter(recipes)

            recipeAdapter = RecipeShowAdapter(recipes)
            recyclerView.adapter = recipeAdapter

            recipeAdapter.onItemClick = {
                val bundle = Bundle()
                bundle.putString("data", Gson().toJson(it))
                val dashboardFragment = SingleRecipeFragment()
                dashboardFragment.arguments = bundle
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainerView, dashboardFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }

        return binding.root
    }

}