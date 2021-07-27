package com.example.cookingrecipe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.entities.Meals


class IngredientsAdapter(private var ingredientlist:ArrayList<Meals>): RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var ingredient: TextView = view.findViewById(R.id.ingredientContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.ingredient_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val ingredientlists = ingredientlist[position]
       holder.ingredient.text = ingredientlists.detail
    }

    override fun getItemCount(): Int {
        return ingredientlist.size
    }


}