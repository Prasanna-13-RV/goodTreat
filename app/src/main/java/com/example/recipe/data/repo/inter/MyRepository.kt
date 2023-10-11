package com.example.recipe.data.repo.inter

import androidx.lifecycle.LiveData
import com.example.recipe.data.entity.RecipeEntity

interface MyRepository {

    fun getAllRecipes() : LiveData<List<RecipeEntity>>

//    suspend fun addRecipe(recipeEntity: RecipeEntity) : Long
}