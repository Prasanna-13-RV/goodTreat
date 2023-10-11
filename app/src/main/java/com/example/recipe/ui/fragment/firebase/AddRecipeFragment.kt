package com.example.recipe.ui.fragment.firebase

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.recipe.R
import com.example.recipe.databinding.FragmentAddRecipeBinding
import com.example.recipe.databinding.FragmentShowRecipesBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class AddRecipeFragment : Fragment() {
    private lateinit var binding: FragmentAddRecipeBinding
    private val db = Firebase.firestore
    private val TAG = "AddRecipeFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddRecipeBinding.inflate(inflater, container, false)

        binding.recipeAddButton.setOnClickListener {

            val current = LocalDate.now()

            // Create a new user with a first and last name
            val recipe = hashMapOf(
                "recipeName" to binding.recipeNameText.text.toString(),
                "recipeDescription" to binding.recipeDescriptionText.text.toString(),
                "recipeImage" to binding.recipeImageText.text.toString(),
                "recipeCreateDate" to current.toString()
            )
            Log.d(TAG, recipe.toString())

            // Add a new document with a generated ID
            db.collection("recipes")
                .add(recipe)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }




        return binding.root
    }

}