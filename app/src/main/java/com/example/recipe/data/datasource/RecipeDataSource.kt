package com.example.recipe.data.datasource

import com.example.recipe.data.entity.MyRecipe
import retrofit2.Response

interface RecipeDataSource {

    suspend fun getAllRecipes() : Response<MyRecipe>
}