package com.example.hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), "Toppings: "+message,
                Toast.LENGTH_SHORT).show();
    }

    public void showtext(View view) {
        mOrderMessage="";
        CheckBox c1= findViewById(R.id.o1);
        CheckBox c2= findViewById(R.id.o2);
        CheckBox c3= findViewById(R.id.o3);
        CheckBox c4= findViewById(R.id.o4);
        CheckBox c5= findViewById(R.id.o5);
        if(c1.isChecked())
            mOrderMessage+="*"+ c1.getText().toString();
        if(c2.isChecked())
            mOrderMessage+="*"+ c2.getText().toString();
        if(c3.isChecked())
            mOrderMessage+="*"+ c3.getText().toString();
        if(c4.isChecked())
            mOrderMessage+="*"+ c4.getText().toString();
        if(c5.isChecked())
            mOrderMessage+="*"+ c5.getText().toString();
        displayToast(mOrderMessage);
    }

}