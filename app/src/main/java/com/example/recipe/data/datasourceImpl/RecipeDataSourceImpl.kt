package com.example.recipe.data.datasourceImpl

import com.example.recipe.data.datasource.RecipeDataSource
import com.example.recipe.data.entity.MyRecipe
import com.example.recipe.data.services.RecipeService
import retrofit2.Response
import javax.inject.Inject

class RecipeDataSourceImpl @Inject constructor(private val recipeService: RecipeService) :
    RecipeDataSource {
    override suspend fun getAllRecipes(): Response<MyRecipe> = recipeService.getAllNews("a")
}