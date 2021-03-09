package com.example.exoplanets_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("EXOPLANETS");
    ArrayList<Planet> planets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // myRef.child("GJ 1061 c").setValue(new Planet("GJ 1061 c","Gliese 1061","12","6.7","221,387"));
       // myRef.child("Proxima Centauri b").setValue(new Planet("Proxima Centauri b","Proxima Centauri","4.1","11.186","77,488"));
       // myRef.child("Kepler-1649 c").setValue(new Planet("Kepler-1649 c","Kepler-1649","301","19.5","5,551,937 "));




        setupButtonGJ();
        setupButtonKep();
        setupButtonProx();
        setupFirebaseDataChange();

    }


    private void setupFirebaseDataChange() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()");        // debugging log
                planets = getPlanets(dataSnapshot);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });

    }


    public ArrayList<Planet> getPlanets(DataSnapshot dataSnapshot){

        ArrayList<Planet> planets = new ArrayList<>();
        for(DataSnapshot data : dataSnapshot.getChildren()){
            Planet planet = data.getValue(Planet.class);
            planets.add(planet);
        }

        return planets;
    }

    private void setupButtonProx(){

        buttonProx = findViewById(R.id.buttonProx);
        buttonProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String key3 = myRef.child("Proxima Centauri b").push().getKey();

                Intent detailActIntent = new Intent(view.getContext(), PlanetViewHolder.class);
                detailActIntent.putExtra("Planet", planets.get(0));
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
                startActivity(detailActIntent);
            }
        });

    }
}