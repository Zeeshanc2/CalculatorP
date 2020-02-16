package com.example.calculatorp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class History extends AppCompatActivity implements ValueEventListener{

    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Calculation");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        myRef.addValueEventListener(this);
    }
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        ArrayList<ModelClass> myArrayList= new ArrayList<>();
        myArrayList.clear();
        for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
            ModelClass hsm = dataSnapshot1.getValue(ModelClass.class);
            myArrayList.add(hsm);
            MyAdapter myAdapter = new MyAdapter(this,myArrayList);
            ListView myList = findViewById(R.id.myListView);
            myList.setAdapter(myAdapter);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }
}
