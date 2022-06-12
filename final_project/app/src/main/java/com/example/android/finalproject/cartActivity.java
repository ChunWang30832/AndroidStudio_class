package com.example.android.finalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.LinkedList;

public class cartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private cartViewAdapter adapter;
    private final String count = "數量：";
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView = findViewById(R.id.rView);

        LinkedList<String> itemTitle = new LinkedList<>();
        LinkedList<String> itemDescription = new LinkedList<>();

        itemTitle.add("Test Item1");
        itemDescription.add(count + "測試數量");

        itemTitle.add("Test Item2");
        itemDescription.add(count + "測試數量");

        adapter = new cartViewAdapter(this, itemTitle, itemDescription);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toolbar toolbar = findViewById(R.id.cart_toolbar);
        toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}