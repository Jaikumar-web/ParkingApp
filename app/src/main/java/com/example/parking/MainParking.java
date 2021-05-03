package com.example.parking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainParking extends AppCompatActivity {

    CardView CarBooking;
    CardView BikeBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_parking);
        // CarParking Intent
        CarBooking = findViewById(R.id.Carbook);
        CarBooking.setOnClickListener(v -> startActivity(new Intent(MainParking.this,Carbook.class)));


        // Bike Parking Intent
        BikeBooking = findViewById(R.id.BikeBook);
        BikeBooking.setOnClickListener(v -> startActivity(new Intent(MainParking.this,Bikebook.class)));


    }
}