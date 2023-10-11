package com.example.recipe.data.entity

import android.os.Parcelable


data class Meal(
    val dateModified: Any,
    val idMeal: String,
    val strArea: String,
    val strCategory: String,
    val strInstructions: String,
    val strMeal: String,
    val strMealThumb: String,
    val strSource: String,
    val strTags: String,
    val strYoutube: String
)