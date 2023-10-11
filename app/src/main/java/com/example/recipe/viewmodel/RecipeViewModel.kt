package com.example.recipe.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe.data.entity.Meal
import com.example.recipe.data.entity.MyRecipe
import com.example.recipe.data.entity.RecipeEntity
import com.example.recipe.data.repo.inter.MyRepository
import com.example.recipe.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val repository: MyRepository
) :
    ViewModel() {


    fun addLocalRecipes(recipeEntity: RecipeEntity) {
        viewModelScope.launch {
//            repository.addRecipe(recipeEntity)
        }
        Log.d("myviewmodel", recipeEntity.toString())
    }

    private val _myRecipes = MutableLiveData<List<Meal>>()
    val myRecipes: LiveData<List<Meal>> = _myRecipes

    fun getAllRecipes() {
        viewModelScope.launch {
            val recipes = recipeRepository.getAllRecipe()
            _myRecipes.postValue(recipes)
        }
    }


}