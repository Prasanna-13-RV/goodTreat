package com.example.recipe.di

import com.example.recipe.data.datasource.RecipeDataSource
import com.example.recipe.data.datasourceImpl.RecipeDataSourceImpl
import com.example.recipe.domain.repository.RecipeRepository
import com.example.recipe.domain.repositoryImpl.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesNewsRepository(
        recipeDataSource: RecipeDataSource
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeDataSource)
    }


}