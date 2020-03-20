package com.example.qrcodeattendencesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Display;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList extends AppCompatActivity {


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Adapter adapter;
    private List<Model> list;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_list);

        recyclerView = findViewById(R.id.RecycelerId);
        linearLayoutManager = new LinearLayoutManager(this);

        String Hold_Id = getIntent().getExtras().getString("Id");

        list = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Upload");


        databaseReference.orderByChild("id").equalTo(Hold_Id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot != null){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                        Model model = snapshot.getValue(Model.class);

                        list.add(model);

                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        adapter = new Adapter(EmployeeList.this,list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);



    }
}
