package com.example.recipe.domain.repository

import com.example.recipe.data.entity.Meal
import com.example.recipe.data.entity.MyRecipe
import retrofit2.Response

interface RecipeRepository {

    suspend fun getAllRecipe() : List<Meal>

}