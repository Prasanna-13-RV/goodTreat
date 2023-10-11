package com.example.recipe.ui.fragment.firebase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.example.recipe.R
import com.example.recipe.data.entity.Meal
import com.example.recipe.databinding.FragmentMySingleRecipeBinding
import com.example.recipe.databinding.FragmentShowRecipesBinding
import com.example.recipe.databinding.FragmentSingleRecipeBinding
import com.google.gson.Gson

class MySingleRecipeFragment : Fragment() {

    private lateinit var binding: FragmentMySingleRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMySingleRecipeBinding.inflate(inflater, container, false)

        val description = binding.recipeSingleDescription
        val image = binding.recipeSingleImage

        var titleBar = view?.findViewById<Toolbar>(R.id.toolbar)


        val inputData = arguments?.getString("data")
        if (inputData != null) {
            Log.d("myRecipe", inputData)
            titleBar?.title = "Name"



            val recipe: Meal = Gson().fromJson(inputData, Meal::class.java)
            context?.let { Glide.with(it).load(recipe.strMealThumb).into(image) }
        } else {
            Toast.makeText(context, "Server error", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }

}