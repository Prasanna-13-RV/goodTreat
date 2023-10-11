package com.example.recipe.di

import com.example.recipe.data.datasource.RecipeDataSource
import com.example.recipe.data.datasourceImpl.RecipeDataSourceImpl
import com.example.recipe.data.services.RecipeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Singleton
    @Provides
    fun provideRecipeDataSource(recipeService: RecipeService) : RecipeDataSource {
        return RecipeDataSourceImpl(
            recipeService
        )
    }
}