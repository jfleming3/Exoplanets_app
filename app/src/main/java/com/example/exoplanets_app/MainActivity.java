package com.example.exoplanets_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button buttonKep, buttonGJ, buttonProx;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

              //  Planet gj = new Planet("GJ 1061 c","Gliese 1061","12","6.7","221,387");
               //myRef.setValue(gj);
                String value = dataSnapshot.getValue(String.class);
                Log.d("CIS3334", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
               Log.w("CIS3334", "Failed to read value.", error.toException());
            }
        });


        setupButtonGJ();
        setupButtonKep();
        setupButtonProx();
    }

    private void setupButtonProx(){

        buttonProx = findViewById(R.id.buttonProx);
        buttonProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent detailActIntent = new Intent(view.getContext(), PlanetViewHolder.class);
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