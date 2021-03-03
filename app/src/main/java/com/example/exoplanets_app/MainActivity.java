package com.example.exoplanets_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonKep, buttonGJ, buttonProx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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