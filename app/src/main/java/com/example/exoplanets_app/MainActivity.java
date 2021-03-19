package com.example.exoplanets_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonKep, buttonGJ, buttonProx;
    ImageButton KepButton, gjButton, ProxButton;
    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef; //= database.getReference("EXOPLANETS");
    ArrayList<Planet> planets;
    PlanetFirebaseData firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase = new PlanetFirebaseData();
        //myRef = firebase.open();
        //myRef.child("GJ 1061 c").setValue(new Planet("GJ 1061 c","Gliese 1061","12","6.7","221,387","https://exoplanets.nasa.gov/exoplanet-catalog/7592/gj-1061-c/"));
        //myRef.child("Proxima Centauri b").setValue(new Planet("Proxima Centauri b","Proxima Centauri","4.1","11.186","77,488","https://exoplanets.nasa.gov/exoplanet-catalog/7167/proxima-centauri-b/"));
        //myRef.child("Kepler-1649 c").setValue(new Planet("Kepler-1649 c","Kepler-1649","301","19.5","5,551,937", "https://exoplanets.nasa.gov/exoplanet-catalog/7616/kepler-1649-c/"));


        setupButtonGJ();
        setupButtonKep();
        setupButtonProx();
        setupFirebaseDataChange();

    }


    private void setupFirebaseDataChange() {

        firebase = new PlanetFirebaseData();
        myRef = firebase.open();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()");        // debugging log
                planets = firebase.getPlanets(dataSnapshot);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });

    }



    private void setupButtonProx(){

        buttonProx = findViewById(R.id.buttonProx);
        buttonProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String key3 = myRef.child("Proxima Centauri b").push().getKey();

                Intent detailActIntent = new Intent(view.getContext(), PlanetViewHolder.class);
                detailActIntent.putExtra("Planet", planets.get(2));
                startActivity(detailActIntent);
            }
        });


        ProxButton = findViewById(R.id.ProxButton);
        ProxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String key3 = myRef.child("Proxima Centauri b").push().getKey();

                Intent detailActIntent = new Intent(view.getContext(), PlanetViewHolder.class);
                detailActIntent.putExtra("Planet", planets.get(2));
                startActivity(detailActIntent);
            }
        });
    }


    private void setupButtonGJ(){


        buttonGJ = findViewById(R.id.buttonGJ);
        buttonGJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent detailActIntent = new Intent(view.getContext(), PlanetViewHolder.class);
                detailActIntent.putExtra("Planet", planets.get(0));
                startActivity(detailActIntent);
            }
        });


        gjButton = findViewById(R.id.gjButton);
        gjButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent detailActIntent = new Intent(view.getContext(), PlanetViewHolder.class);
                detailActIntent.putExtra("Planet", planets.get(0));
                startActivity(detailActIntent);
            }
        });

    }

    private void setupButtonKep(){

        buttonKep= findViewById(R.id.buttonKep);
        buttonKep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent detailActIntent = new Intent(view.getContext(), PlanetViewHolder.class);
                detailActIntent.putExtra("Planet", planets.get(1));
                startActivity(detailActIntent);
            }
        });

        KepButton = findViewById(R.id.KepButton);
        KepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent detailActIntent = new Intent(view.getContext(), PlanetViewHolder.class);
                detailActIntent.putExtra("Planet", planets.get(1));
                startActivity(detailActIntent);
            }
        });

    }
}