package com.example.boonvoyage;

import static android.content.ContentValues.TAG;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;

public class Home extends AppCompatActivity {

    ImageButton Menu;
    FloatingActionButton SOS;
    Button navigate;

    private int sosClick = 0;

    public Trip trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DynamicColors.applyToActivityIfAvailable(this);

//        Trip Init

        trip = new Trip();

        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), "AIzaSyCVIwtjBWw91NZUjFZ3K3YZvYjiJuziqF0");
        }

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment fromLocation = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.startLocation);

        // Specify the types of place data to return.
        fromLocation.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the response.
        fromLocation.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
                LatLng loc = place.getLatLng();
                trip.startLat = loc.latitude;
                trip.startLong = loc.longitude;
            }


            @Override
            public void onError(@NonNull Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });



//        To-Location Fragments
        AutocompleteSupportFragment toLocation = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.endLocation);

        // Specify the types of place data to return.
        toLocation.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the response.
        toLocation.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());

                LatLng loc = place.getLatLng();
                trip.endLat = loc.latitude;
                trip.endLong = loc.longitude;
            }


            @Override
            public void onError(@NonNull Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

//        Button actions

        Menu = findViewById(R.id.menu);
        navigate = findViewById(R.id.startTrip);
        SOS = findViewById(R.id.SOSfab);

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                startActivity(new Intent(Home.this,Menu.class));
            }
        });

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Send Object Trip to another Intent for navigation Purposes


            }
        });

        SOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(sosClick<2){
                    sosClick++;
                    Toast.makeText(Home.this, Integer.toString(3-sosClick)+ "  Click Away",0).show();
                }
                else{
                    sosClick = 0;

//                    Functionality:

                    Toast.makeText(Home.this, "SOS functionality called", Toast.LENGTH_SHORT).show();

                }
//
            }
        });

    }
}