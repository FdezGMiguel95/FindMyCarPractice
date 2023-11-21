package com.example.findmycarpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ParkingsActivity extends AppCompatActivity {
    private Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkings);
        ArrayList<Aparcamiento> parkings = new ArrayList<>();
        btnAdd = (Button) findViewById(R.id.btnAddParking);
        parkings.add(new Aparcamiento("Madrid", 40.4165000f ,-3.7025600f));
        parkings.add(new Aparcamiento("Barcelona", 41.38879f , 2.15899f));

        RecyclerView rView = (RecyclerView) findViewById(R.id.rvPoints);
        AdapterParking pointsAdapter = new AdapterParking(parkings);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(this));
        rView.setAdapter(pointsAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}