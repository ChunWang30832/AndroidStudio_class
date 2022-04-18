package com.example.reciperecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RecipeActivity : AppCompatActivity() {

    private lateinit var title_text: TextView
    private lateinit var content_text: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        title_text = findViewById(R.id.item_title)
        content_text = findViewById(R.id.item_context)

        val title = intent.getStringExtra("name").toString()
        title_text.text = title
        val content = intent.getStringExtra("description").toString() + "\n\n" + intent.getStringExtra("context").toString()

        content_text.text = content
    }


}