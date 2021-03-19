package com.example.exoplanets_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class PlanetViewHolder extends AppCompatActivity {



    Button buttonWeb,buttonBack;
    TextView textViewName,textViewDistance,textViewOrbit,textViewHost,textViewTravel;
    ImageView imageViewPlanet;
    Planet planet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_view);

        textViewName = findViewById(R.id.textViewName);
        imageViewPlanet = findViewById(R.id.imageViewPlanet);
        textViewDistance = findViewById(R.id.textViewDistance);
        textViewOrbit = findViewById(R.id.textViewOrbit);
        textViewHost = findViewById(R.id.textViewHost);
        textViewTravel = findViewById(R.id.textViewTravel);

        setupButtonWeb();
        setupButtonBack();
        planetInfo();
        setupImage();
    }



    public void planetInfo(){

        Intent i = getIntent();
        planet = (Planet)i.getSerializableExtra("Planet");
        textViewName.setText(planet.getName());
        textViewDistance.setText(planet.getDist() + " Light Years");
        textViewOrbit.setText(planet.getOrbit() + " Days");
        textViewHost.setText(planet.getHost());
        textViewTravel.setText(planet.getTravel() + " Years");

    }

    private void setupImage(){
        if(planet.getName().matches("Kepler-1649 c"))
            imageViewPlanet.setImageResource(R.drawable.kepler);
        else if(planet.getName().matches("GJ 1061 c"))
            imageViewPlanet.setImageResource(R.drawable.gj);
        else
            imageViewPlanet.setImageResource(R.drawable.proxima);
    }


    private void setupButtonBack(){
        buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }


     public void setupButtonWeb() {
        buttonWeb = findViewById(R.id.buttonWeb);
        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri webpage = Uri.parse(planet.getUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });
    }
}