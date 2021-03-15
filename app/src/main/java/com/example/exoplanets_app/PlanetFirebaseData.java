package com.example.exoplanets_app;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PlanetFirebaseData {





    public static final String TAG = "EXOPLANETS";
    DatabaseReference myRef;
    ArrayList<Planet> planets;


    public DatabaseReference open(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference(TAG);
        planets = new ArrayList<>();
        return myRef;
    }


    public ArrayList<Planet> getPlanets(DataSnapshot dataSnapshot){

        ArrayList<Planet> planets = new ArrayList<>();
        for(DataSnapshot data : dataSnapshot.getChildren()){
            Planet planet = data.getValue(Planet.class);
            planets.add(planet);
        }

        return planets;
    }


}
