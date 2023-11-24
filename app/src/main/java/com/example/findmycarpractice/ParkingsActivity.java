package com.example.findmycarpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ParkingsActivity extends AppCompatActivity {
    private String uuid;
    private Button btnGoAdd, btnGoMap;
    private Aparcamiento a;
    private DatabaseReference dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkings);
        ArrayList<Aparcamiento> parkings = new ArrayList<>();
        btnGoAdd = (Button) findViewById(R.id.btnAddParking);
        btnGoMap = (Button) findViewById(R.id.btnGoToMap);
        dbRef = FirebaseDatabase.getInstance().getReference().child("ParkSlots");

        parkings.add(new Aparcamiento("Madrid", 40.4165000f ,-3.7025600f));
        parkings.add(new Aparcamiento("Barcelona", 41.38879f , 2.15899f));

        RecyclerView rView = (RecyclerView) findViewById(R.id.rvPoints);
        AdapterParking pointsAdapter = new AdapterParking(parkings);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(this));
        rView.setAdapter(pointsAdapter);
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    a = snapshot.getValue(Aparcamiento.class);
                    if (a != null){
                        parkings.add(a);
                    }
                }
                pointsAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        btnGoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seeOnMap = new Intent(ParkingsActivity.this, MapActivity.class);
                startActivity(seeOnMap);
            }
        });
        btnGoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addAparcamiento = new Intent(ParkingsActivity.this, CreateParkingActivity.class);
                startActivity(addAparcamiento);
            }
        });
    }
}