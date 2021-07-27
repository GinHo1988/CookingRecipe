package com.example.cookingrecipe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.R
import com.example.cookingrecipe.entities.Meals

class InstructionAdapter(private var instructionlist:ArrayList<Meals>): RecyclerView.Adapter<InstructionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var instruction: TextView = view.findViewById(R.id.instructionContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return InstructionAdapter.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.instruction_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val instructionlist = instructionlist[position]
        holder.instruction.text = instructionlist.detail
    }

    override fun getItemCount(): Int {
        return instructionlist.size
    }
}