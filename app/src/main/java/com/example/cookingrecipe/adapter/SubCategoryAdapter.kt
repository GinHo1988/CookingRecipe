package com.example.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.entities.Recipes


class SubCategoryAdapter(private var recipesList:ArrayList<Recipes>,var clickListener: OnItemClickListener):RecyclerView.Adapter<SubCategoryAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var subDish: TextView = view.findViewById(R.id.sub_dish)
        var subimg_dish:ImageView=view.findViewById(R.id.subimg_dish)

        fun initialize(item:Recipes, action: OnItemClickListener){
            subDish.text = item.dishName

            itemView.setOnClickListener{
                action.onSubItemClick(item,adapterPosition)
            }
        }
    }


    interface OnItemClickListener {
        fun onSubItemClick(item:Recipes,position: Int)
    }

    fun setData(arrData : List<Recipes>){
        recipesList = arrData as ArrayList<Recipes>
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sub_category,parent,false))
    }

    override fun onBindViewHolder(holder: SubCategoryAdapter.ViewHolder, position: Int) {
        val subCategory = recipesList[position]
        holder.subDish.text = subCategory.dishName
        holder.subimg_dish.setImageResource(recipesList.get(position).picture)
        holder.initialize(recipesList.get(position),clickListener)
    }


    override fun getItemCount(): Int {
        return recipesList.size
    }


}