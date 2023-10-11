package com.example.recipe.data.entity

import android.widget.EditText
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.Date
import javax.annotation.processing.Generated

@Entity
class RecipeEntity(
    @PrimaryKey
    val recipeId: Int,
    val recipeName: String,
    val recipeDescription: String,
    val recipeImage : String,
    val recipeCreateDate: String
)


