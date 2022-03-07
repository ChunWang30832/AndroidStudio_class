package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    private int mCount;
    private TextView mShowCount;
    private Button zero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        zero = (Button) findViewById(R.id.ze_ro);
    }

    public void add_count(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if(mCount!=0)
            zero.setBackgroundColor(Color.RED);
        if(mCount%2==0)
            view.setBackgroundColor(Color.MAGENTA);
        if(mCount%2==1)
            view.setBackgroundColor(Color.TRANSPARENT);


    }

    public void show_Toast(View view) {
        Toast.makeText(this,"Hello Toast!",Toast.LENGTH_SHORT).show();
    }

    public void set_zero(View view) {
        mCount=0;
        zero.setBackgroundColor(Color.GRAY);
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}