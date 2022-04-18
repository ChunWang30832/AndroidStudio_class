package com.example.reciperecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var _recyclerView: RecyclerView
    private lateinit var _recipeListAdapter: RecipeListAdapter
    private val _recipeList: Array<Recipe> = arrayOf(
        Recipe("Pizza", "recipe of Pizza","(make a pizza)"),
        Recipe("Rice", "recipe of Rice","(make rice)"),
        Recipe("Cake", "recipe of Cake","(make a Cake)"),
        Recipe("Apple", "recipe of Apple","(make a apple)"),
        Recipe("Banana", "recipe of Banana","(make a banana)"),
        Recipe("Pineapple", "recipe of Pineapple","(make a pineapple)"),
        Recipe("Dount", "recipe of Dount","(make a dount)"),
        Recipe("Cheese", "recipe of Cheese","(make a cheese)"),
        Recipe("Sandwich", "recipe of Sandwich","(make a sandwich)"),
        Recipe("Burger", "recipe of Burger","(make a burger)"),
        Recipe("Noodles", "recipe of Noodles","(make noodle)"),
        Recipe("Bread", "recipe of Bread","(make a bread)"),
        Recipe("Chicken Nugget", "recipe of Chicken Nugget","(make Chicken Nugget)"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _recipeListAdapter = RecipeListAdapter(_recipeList)
        _recyclerView = findViewById(R.id.recyclerView)
        _recyclerView.adapter = _recipeListAdapter
        _recyclerView.layoutManager = LinearLayoutManager(this)
    }
}