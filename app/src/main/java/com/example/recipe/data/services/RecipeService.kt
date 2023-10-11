package com.example.recipe.data.services

import com.example.recipe.data.entity.MyRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    @GET("json/v1/1/search.php")
    suspend fun getAllNews(
        @Query(
            "f"
        ) a: String,
    ): Response<MyRecipe>
}