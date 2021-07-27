package com.example.cookingrecipe

import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.adapter.IngredientsAdapter
import com.example.cookingrecipe.adapter.InstructionAdapter
import com.example.cookingrecipe.entities.Meals

class DetailActivity: AppCompatActivity() {

    val ingredientList = ArrayList<Meals>()
    val instructionList = ArrayList<Meals>()

    private lateinit var ingredientsAdapter: IngredientsAdapter
    private lateinit var instructionAdapter: InstructionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val ingredientRecycle:RecyclerView = findViewById(R.id.ingredientRecycle)
        val ingLayoutManager = LinearLayoutManager(this@DetailActivity,LinearLayoutManager.VERTICAL,false)
        ingredientRecycle.layoutManager = ingLayoutManager
        ingredientsAdapter = IngredientsAdapter(ingredientList)
        ingredientRecycle.adapter = ingredientsAdapter

        val instructionRecycle:RecyclerView = findViewById(R.id.instructionRecycle)
        val instLayoutManager = LinearLayoutManager(this@DetailActivity,LinearLayoutManager.VERTICAL,false)
        instructionRecycle.layoutManager = instLayoutManager
        instructionAdapter = InstructionAdapter(instructionList)
        instructionRecycle.adapter = instructionAdapter

        ingredientData()
        instructionData()
        setupHyperLink()
    }

    private fun ingredientData(){
        var ingredient = Meals (1,"1.) Salt to taste")
        ingredientList.add(ingredient)
        ingredient = Meals (2,"2.) Spaghetti  1/2lb")
        ingredientList.add(ingredient)
        ingredient = Meals (3,"3.) Virgin olive oil  3 tablespoons")
        ingredientList.add(ingredient)
        ingredient = Meals (4,"4.) Garlic,sliced  4 cloves")
        ingredientList.add(ingredient)
        ingredient = Meals (5,"5.) Red chili flakes  1 teaspoon")
        ingredientList.add(ingredient)
        ingredient = Meals (6,"6.) fresh parsley, finely chopped  2 tablespoons")
        ingredientList.add(ingredient)
    }

    private fun instructionData(){
        var instruction = Meals (1,"1.) Bring a large pot of salted water to a boil." +
                                 " Cook the pasta according to package instructions.Save 1/4 cup" +
                                 " (60ml) of pasta water , then drain")
        instructionList.add(instruction)
        instruction = Meals (2,"2.) Add the oil and galic to a large cold saute pan." +
                              " Turn the heat to medium-low and slowly heat up until the garlic" +
                              " is fragrant and lightly colored, about 3 minutes.")
        instructionList.add(instruction)
        instruction = Meals (3,"3.) Add the chile flakes and cook for another minute.")
        instructionList.add(instruction)
        instruction = Meals (4,"4.) Add the reserved pasta water and bring to a simmer." +
                              " Add the cooked spaghetti and parsley, if using. Stir until the " +
                              "pasta is well-coated. Season with salt to taste.")
        instructionList.add(instruction)
        instruction = Meals (5,"5.) Enjoy! ")
        instructionList.add(instruction)
    }

    fun setupHyperLink(){
        val link:TextView= findViewById(R.id.link)
        link.setMovementMethod(LinkMovementMethod.getInstance())
        link.setLinkTextColor(Color.BLUE)

        val link2:TextView = findViewById(R.id.link2)
        link2.setMovementMethod(LinkMovementMethod.getInstance())
        link2.setLinkTextColor(Color.BLUE)


        val link3:TextView = findViewById(R.id.link3)
        link3.setMovementMethod(LinkMovementMethod.getInstance())
        link3.setLinkTextColor(Color.BLUE)

        val link4:TextView = findViewById(R.id.link4)
        link4.setMovementMethod(LinkMovementMethod.getInstance())
        link4.setLinkTextColor(Color.BLUE)

    }




}