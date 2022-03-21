package com.example.android.HW_3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        int sc_count = intent.getIntExtra("count", 0);
        TextView view_count = (TextView) findViewById(R.id.second_count);
        view_count.setText(Integer.toString(sc_count));
    }

}