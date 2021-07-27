package com.example.cookingrecipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookingrecipe.adapter.MainCategoryAdapter
import com.example.cookingrecipe.entities.Recipes
import com.example.recipeapp.adapter.SubCategoryAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity(), MainCategoryAdapter.OnItemClickListener,SubCategoryAdapter.OnItemClickListener{

    val mainrecipesList = ArrayList<Recipes>()
    val subrecipesList = ArrayList<Recipes>()
    private lateinit var mainAdapter: MainCategoryAdapter
    private lateinit var subAdapter: SubCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        title = "Cook Recipes"

        setupNavigation()

        val maincategory: RecyclerView =findViewById(R.id.main_category)
        val mainLayoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
        maincategory.layoutManager = mainLayoutManager
        mainAdapter = MainCategoryAdapter(mainrecipesList,this)
        maincategory.adapter = mainAdapter



        val subcategory: RecyclerView = findViewById(R.id.sub_category)
        val subLayoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
        subcategory.layoutManager = subLayoutManager
        subAdapter = SubCategoryAdapter(subrecipesList,this)
        subcategory.adapter = subAdapter





        mainCategoryData()
        subCategoryData()
    }

    private fun mainCategoryData(){
        var mainCaDish = Recipes(1,"Beef",R.drawable.cat_img)
        mainrecipesList.add(mainCaDish)
        mainCaDish = Recipes(2,"Chicken",R.drawable.cat_img)
        mainrecipesList.add(mainCaDish)
        mainCaDish = Recipes(3,"Lamb",R.drawable.cat_img)
        mainrecipesList.add(mainCaDish)
        mainCaDish = Recipes(4,"Dessert",R.drawable.cat_img)
        mainrecipesList.add(mainCaDish)
        mainAdapter.notifyDataSetChanged()
    }

    private fun subCategoryData(){
        var subCaDish = Recipes(1,"Spaghetti With Garlic and Olive Oil",R.drawable.spaghatti_pic)
        subrecipesList.add(subCaDish)
        subCaDish = Recipes(2,"Chicken Noodle Soup",R.drawable.chicken_noodle)
        subrecipesList.add(subCaDish)
        subCaDish = Recipes(3,"Lamb with Curry",R.drawable.lamp_curry)
        subrecipesList.add(subCaDish)
        subCaDish = Recipes(4,"Apple Pie",R.drawable.apple_pie)
        subrecipesList.add(subCaDish)
        subAdapter.notifyDataSetChanged()
    }

    private fun setupNavigation(){
        val nalView: BottomNavigationView = findViewById(R.id.nav_view)
        nalView.setOnNavigationItemReselectedListener { item ->
            when(item.itemId){
                R.id.home ->{
                    Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile ->{

                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }

        }
    }

    override fun onItemClick(item: Recipes, position: Int) {
      Toast.makeText(this,item.dishName,Toast.LENGTH_SHORT).show()
    }

    override fun onSubItemClick(item: Recipes, position: Int) {
        if (position == 0) {
            Toast.makeText(this, item.dishName, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetailActivity::class.java)

            startActivity(intent)
        }else{
            Toast.makeText(this, item.dishName, Toast.LENGTH_SHORT).show()
        }

    }
}