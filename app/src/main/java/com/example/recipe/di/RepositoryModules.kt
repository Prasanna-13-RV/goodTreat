package com.example.recipe.di

import com.example.recipe.data.dao.RecipeDao
import com.example.recipe.data.repo.impl.MyRepoImpl
import com.example.recipe.data.repo.inter.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModules {
    @Singleton
    @Provides
    fun providesRepository(recipeDao: RecipeDao) : MyRepository {
        return MyRepoImpl(recipeDao)
    }

}