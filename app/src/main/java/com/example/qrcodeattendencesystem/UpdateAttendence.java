package com.example.qrcodeattendencesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qrcodeattendencesystem.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateAttendence extends AppCompatActivity implements View.OnClickListener {

    public static TextView UserId;

    private EditText Date,Id,InTime,OutTine,OverTime;

    private Button Add;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_attendence);

        UserId = findViewById(R.id.textView4);

        String GetUserID = getIntent().getExtras().getString("ID");

        UserId.setText(GetUserID);

        UserId = findViewById(R.id.textView4);
        databaseReference = FirebaseDatabase.getInstance().getReference("Upload");

        Date =  findViewById(R.id.editText8);
        Id = findViewById(R.id.editText9);
        InTime = findViewById(R.id.editText);
        OutTine = findViewById(R.id.editText10);
        OverTime = findViewById(R.id.editText11);

        Add = findViewById(R.id.button5);
        Add.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String GetDate = Date.getText().toString().trim();
        String GetId = Id.getText().toString().trim();
        String GetInTime = InTime.getText().toString().trim();
        String GetOutTime = OutTine.getText().toString().trim();
        String GetOverTime = OverTime.getText().toString().trim();

        Model model = new Model(GetDate,GetId,GetInTime,GetOutTime,GetOverTime);

        String Key = databaseReference.push().getKey();

        databaseReference.child(Key).setValue(model);

        Toast.makeText(this,"ADDED INFO",Toast.LENGTH_LONG).show();




    }
}
