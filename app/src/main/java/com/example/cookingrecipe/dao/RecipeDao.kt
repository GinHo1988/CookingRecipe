package com.example.cookingrecipe.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cookingrecipe.entities.Recipes


@Dao
interface RecipeDao {
    @get:Query("SELECT * FROM Recipes ORDER BY id DESC")
    val allRecipes: List<Recipes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipes(recipes: Recipes)
}