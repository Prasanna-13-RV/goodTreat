package com.example.recipe.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recipe.data.dao.RecipeDao
import com.example.recipe.data.entity.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}