package com.example.cookingrecipe.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.entities.Recipes

class MainCategoryAdapter(private var recipesList:ArrayList<Recipes>,var clickListener:OnItemClickListener): RecyclerView.Adapter<MainCategoryAdapter.ViewHolder>() {



   class ViewHolder(view: View):RecyclerView.ViewHolder(view){
       var mainDish: TextView = view.findViewById(R.id.main_dish)


       fun initialize(item:Recipes,action:OnItemClickListener){
           mainDish.text = item.dishName

           itemView.setOnClickListener{
               action.onItemClick(item,adapterPosition)
           }
       }
    }

    interface OnItemClickListener {
        fun onItemClick(item:Recipes,position: Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainCategoryAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_category,parent,false))
    }

    override fun onBindViewHolder(holder: MainCategoryAdapter.ViewHolder, position: Int) {
        val mainCategory = recipesList[position]
        holder.mainDish.text =mainCategory.dishName
        holder.initialize(recipesList.get(position),clickListener)

    }

    override fun getItemCount(): Int {
        return recipesList.size
    }
}








