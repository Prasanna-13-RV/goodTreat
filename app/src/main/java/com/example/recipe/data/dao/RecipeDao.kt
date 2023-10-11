package com.example.recipe.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.recipe.data.entity.RecipeEntity

@Dao
interface RecipeDao {
    @Query("SELECT * FROM RecipeEntity")
    fun getAllRecipe(): LiveData<List<RecipeEntity>>

//    @Insert
//    suspend fun insertRecipe(recipeEntity: RecipeEntity)

//    @Query("DELETE FROM RecipeEntity WHERE recipeId = :id")
//    suspend fun deleteRecipeById(id : Int)


//    @Delete
//    suspend fun deleteRecipe(recipeEntity: RecipeEntity)

}