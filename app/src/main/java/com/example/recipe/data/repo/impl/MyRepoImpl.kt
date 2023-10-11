package com.example.recipe.data.repo.impl

import androidx.lifecycle.LiveData
import com.example.recipe.data.dao.RecipeDao
import com.example.recipe.data.entity.RecipeEntity
import com.example.recipe.data.repo.inter.MyRepository

class MyRepoImpl(private val recipeDao: RecipeDao) : MyRepository{
    override fun getAllRecipes(): LiveData<List<RecipeEntity>> {
        return recipeDao.getAllRecipe()
    }
//    override fun getAllRecipes(): List<RecipeEntity>

//    override suspend fun addRecipe(recipeEntity: RecipeEntity) : Long  {
//        return recipeDao.insertRecipe(recipeEntity)
//    }
}