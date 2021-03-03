package com.example.exoplanets_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlanetViewHolder extends AppCompatActivity implements webButton{


    Button buttonWeb,buttonBack;
    TextView textViewName,textViewDistance,textViewOrbit,textViewHost,textViewTravel;


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