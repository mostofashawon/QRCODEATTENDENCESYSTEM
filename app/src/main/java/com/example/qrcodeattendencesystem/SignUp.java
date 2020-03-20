package com.example.qrcodeattendencesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText Admin_Email,Admin_pass,Employee_Email,Employee_pass;
    private Button Admin_login,Employee_login;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        mAuth = FirebaseAuth.getInstance();

        Admin_Email = findViewById(R.id.editText3);
        Admin_pass = findViewById(R.id.editText4);
        Employee_Email = findViewById(R.id.editText7);
        Employee_pass = findViewById(R.id.editText6);

        Admin_login = findViewById(R.id.button);
        Employee_login = findViewById(R.id.button2);

        Admin_login.setOnClickListener(this);
        Employee_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String GetadminEmail = Admin_Email.getText().toString().trim();
        String GetAdminPass = Admin_pass.getText().toString().trim();
        String GetEmployeeEmail = Employee_Email.getText().toString().trim();
        String GetEmployeePass = Employee_pass.getText().toString().trim();

        if (v.getId() == R.id.button){

            Validation(GetadminEmail,GetAdminPass);
            Login(GetadminEmail,GetAdminPass);
        }

        if (v.getId() == R.id.button2){

            validation(GetEmployeeEmail,GetEmployeePass);
            login(GetEmployeeEmail,GetEmployeePass);
        }

    }


    private void Validation(String email, String pass){

        if (email.isEmpty()){

            Admin_Email.setError("insert Input");
            Admin_Email.requestFocus();
        }

        if (pass.isEmpty()){

            Admin_pass.setError("insert Input");
            Admin_pass.requestFocus();
        }

    }

    private void validation(String email, String pass){

        if (email.isEmpty()){

            Employee_Email.setError("insert Input");
            Employee_Email.requestFocus();
        }

        if (pass.isEmpty()){

            Employee_pass.setError("insert Input");
            Employee_pass.requestFocus();
        }

    }



    private void Login(String email, String password){

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent = new Intent(SignUp.this,Attendence.class);
                            //intent.putExtra("Id",password);
                            startActivity(intent);

                        } else {

                            Toast.makeText(SignUp.this,"ERROR",Toast.LENGTH_LONG).show();

                        }

                    }
                });

    }

    private void login(String email,final String password){

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent = new Intent(SignUp.this,EmployeeList.class);
                            intent.putExtra("Id",password);
                            startActivity(intent);

                        } else {

                            Toast.makeText(SignUp.this,"ERROR",Toast.LENGTH_LONG).show();

                        }

                    }
                });

    }
}
