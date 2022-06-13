package com.example.android.finalproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class ADD_NEW extends AppCompatActivity {

    private EditText newtitle;
    private EditText newdes;
    private EditText newprice;

    ArrayList<String> t = new ArrayList<String>();
    ArrayList<String> d = new ArrayList<String>();
    ArrayList<String> p = new ArrayList<String>();
    /*public String t[];
    public String d[];
    public String p[];*/

    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        newtitle = findViewById(R.id.input_title);
        newdes = findViewById(R.id.input_description);
        newprice = findViewById(R.id.input_price);

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

    public void addnewitem(View view) {

        t.add(newtitle.getText().toString());
        d.add(newdes.getText().toString());
        p.add(newprice.getText().toString());


        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("title[]", t.toArray(new String[0]));
        intent.putExtra("description[]", d.toArray(new String[0]));
        intent.putExtra("price[]", p.toArray());

        this.startActivity(intent);

    }


}