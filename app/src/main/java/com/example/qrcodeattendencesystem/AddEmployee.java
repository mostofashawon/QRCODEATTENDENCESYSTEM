package com.example.qrcodeattendencesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AddEmployee extends AppCompatActivity implements View.OnClickListener {

    EditText Emp_Email,Emp_Pass;
    Button Signupbtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        mAuth = FirebaseAuth.getInstance();

        Emp_Email =  findViewById(R.id.editText2);
        Emp_Pass = findViewById(R.id.editText5);
        Signupbtn = findViewById(R.id.button4);
        Signupbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String get_empEmail = Emp_Email.getText().toString().trim();
        String get_empPass = Emp_Pass.getText().toString().trim();

        AddEmplyee(get_empEmail,get_empPass);

    }

    private void AddEmplyee(String email,String pass){

        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(AddEmployee.this,"Successful",Toast.LENGTH_LONG).show();

                        } else {

                            Toast.makeText(AddEmployee.this,"UnSuccessful",Toast.LENGTH_LONG).show();
                        }


                    }
                });



    }
}
