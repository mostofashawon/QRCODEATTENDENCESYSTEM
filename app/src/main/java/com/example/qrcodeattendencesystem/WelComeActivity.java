package com.example.qrcodeattendencesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelComeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Intent WelcomeIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        mAuth = FirebaseAuth.getInstance();

        GetStart();
    }

    private void GetStart() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Thread.sleep(2000);

                        WelcomeIntent = new Intent(WelComeActivity.this, SignUp.class);
                        startActivity(WelcomeIntent);
                        finish();

                }
                catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "The Exception" + e, Toast.LENGTH_LONG).show();
                }
            }
        });

        thread.start();

    }
}
