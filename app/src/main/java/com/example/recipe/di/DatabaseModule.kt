package com.example.recipe.di

import android.app.Application
import androidx.room.Room
import com.example.recipe.data.dao.RecipeDao
import com.example.recipe.data.db.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesRecipeRoomDatabase(context: Application): RecipeDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            RecipeDatabase::class.java,
            "recipeDatabase"
        ).build()
    }

    @Singleton
    @Provides
    fun providesRecipeRoomDao(recipeDatabase: RecipeDatabase): RecipeDao {
        return recipeDatabase.recipeDao()
    }


}