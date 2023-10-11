package com.example.recipe.domain.repositoryImpl

import android.util.Log
import com.example.recipe.data.datasource.RecipeDataSource
import com.example.recipe.data.entity.Meal
import com.example.recipe.data.entity.MyRecipe
import com.example.recipe.domain.repository.RecipeRepository
import retrofit2.Response
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val recipeDataSource: RecipeDataSource) : RecipeRepository {
    override suspend fun getAllRecipe(): List<Meal> {
        Log.d("allrecipesrepo", recipeDataSource.getAllRecipes().body()!!.meals.toString())

       return recipeDataSource.getAllRecipes().body()!!.meals
    }
}