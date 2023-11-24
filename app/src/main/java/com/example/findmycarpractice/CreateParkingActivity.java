package com.example.findmycarpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateParkingActivity extends AppCompatActivity {
    private DatabaseReference dbRef;
    private Button btnSave;
    private EditText etName, etLat, etLong;
    private String nName;
    private double nLat, nLong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_parking);
        dbRef = FirebaseDatabase.getInstance().getReference().child("ParkSlots");
        etName = (EditText) findViewById(R.id.etNombre);
        etLat = (EditText) findViewById(R.id.etLat);
        etLong = (EditText) findViewById(R.id.etLong);
        btnSave = (Button) findViewById(R.id.btnAddParkingAct);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePoint();
            }
        });
    }
    private void savePoint() {
        nName = etName.getText().toString().trim();
        nLat = Double.parseDouble(etLat.getText().toString().trim());
        nLong = Double.parseDouble(etLong.getText().toString().trim());

        Aparcamiento parking = new Aparcamiento(nName, nLat, nLong);
        String k = dbRef.push().getKey();
        dbRef.child(k).setValue(parking);

        Toast.makeText(this, "Guardado con exito", Toast.LENGTH_SHORT).show();
        finish();
    }
}