package com.example.recipe.ui.fragment.remote

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.example.recipe.R
import com.example.recipe.data.entity.Meal
import com.example.recipe.databinding.FragmentShowRecipesBinding
import com.example.recipe.databinding.FragmentSingleRecipeBinding
import com.google.gson.Gson

class SingleRecipeFragment : Fragment() {

    private lateinit var binding: FragmentSingleRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSingleRecipeBinding.inflate(inflater, container, false)

//        val dateModified = binding.recipeSingleDate
        val strCategory = binding.recipeSingleCategory
        val strInstructions = binding.recipeSingleDescription
//        val strMeal = binding.recipeSingleTitle
        val strMealThumb = binding.recipeSingleImage
        val strSource = binding.websiteImage
        val strYoutube = binding.youtubeImage


        val inputData = arguments?.getString("data")
        if (inputData != null) {
            Log.d("myRecipe", inputData)

            val recipe: Meal = Gson().fromJson(inputData, Meal::class.java)
//            activity?.title = recipe.strMeal

//            binding.toolbar.title = recipe.strMeal
//            // Initialize the Toolbar
//            val toolbar = binding.toolbar

//            val activity = requireActivity() as AppCompatActivity
//            activity.setSupportActionBar(toolbar)
//
//            activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//            toolbar.setNavigationOnClickListener {
//                val fragmentManager = requireActivity().supportFragmentManager
//                fragmentManager.popBackStack()
//                Log.d("entryCheck", fragmentManager.backStackEntryCount.toString())
//            }

            strInstructions.text = recipe.strInstructions
//            strMeal.text = recipe.strMeal
            strCategory.text = recipe.strCategory
//            dateModified.text = if (recipe.dateModified == null) "" else recipe.dateModified.toString()

            context?.let { Glide.with(it).load(recipe.strMealThumb).into(strMealThumb) }

            strYoutube.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(recipe.strYoutube)
                intent.setPackage("com.google.android.youtube")
                startActivity(intent)
            }

            strSource.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(recipe.strSource))
                startActivity(i)
            }

        } else {
            Log.d("inputData", "null message")
        }


        return binding.root
    }

}