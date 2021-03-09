package com.example.exoplanets_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class PlanetViewHolder extends AppCompatActivity implements webButton{


    Button buttonWeb,buttonBack;
    TextView textViewName,textViewDistance,textViewOrbit,textViewHost,textViewTravel;
    Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_view);

        textViewName = findViewById(R.id.textViewName);
        textViewDistance = findViewById(R.id.textViewDistance);
        textViewOrbit = findViewById(R.id.textViewOrbit);
        textViewHost = findViewById(R.id.textViewHost);
        textViewTravel = findViewById(R.id.textViewTravel);

        setupButtonWeb();
        setupButtonBack();
        planetInfo();

    }


    public void planetInfo(){

        Intent i = getIntent();
        planet = (Planet)i.getSerializableExtra("Planet");
        textViewName.setText(planet.getName());

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



    @Override
     public void setupButtonWeb() {
        buttonWeb = findViewById(R.id.buttonWeb);

        /*


        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri webpage = Uri.parse("");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });


        */

    }


}