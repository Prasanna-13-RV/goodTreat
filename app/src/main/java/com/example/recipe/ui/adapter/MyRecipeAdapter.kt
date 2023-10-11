package com.example.recipe.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipe.R
import com.example.recipe.data.entity.Meal
import com.example.recipe.data.entity.MyRecipeEntity

class MyRecipeAdapter(private val recipeList: List<MyRecipeEntity>) :
    RecyclerView.Adapter<MyRecipeAdapter.MyViewHolder>() {

    private lateinit var context : Context
    var onItemClick : ((MyRecipeEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.recipe_show_card, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = recipeList[position]

//        Log.d("currentItem", currentItem.toString())
//        https://static.seekingalpha.com/uploads/2012/6/23/261750-13404618131438339-George-Acs.jpg

//        if (currentItem.strMealThumb != "null") {
            Glide.with(context).load(currentItem.recipeImage).into(holder.itemImage)
//        }
        holder.itemTitle.text = currentItem.recipeName
        holder.itemDescription.text = currentItem.recipeDescription

        holder.contentsCard.setOnClickListener {
            onItemClick?.invoke(currentItem)

        }
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val itemImage : ImageView = itemView.findViewById(R.id.recipesImage)
        val itemTitle : TextView = itemView.findViewById(R.id.recipesTitle)
        val itemDescription : TextView = itemView.findViewById(R.id.subtitle)
        val contentsCard : ConstraintLayout = itemView.findViewById(R.id.contentsCard)
    }
}