package com.example.qrcodeattendencesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Attendence extends AppCompatActivity implements View.OnClickListener {

    Button Scan;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);

        Scan = findViewById(R.id.button3);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);
        Scan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button3){


            Intent intent = new Intent(Attendence.this, com.example.qrcodeattendencesystem.Scan.class);
            startActivity(intent);

        }

        if (v.getId() == R.id.floatingActionButton){

            Intent intent = new Intent(Attendence.this,AddEmployee.class);
            startActivity(intent);
        }


    }
}
