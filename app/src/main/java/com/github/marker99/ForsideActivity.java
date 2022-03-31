package com.github.marker99;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ForsideActivity extends AppCompatActivity {

    Button addPetButton;

    RecyclerView petList;
    PetAdapter petAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forside);

        addPetButton = findViewById(R.id.buttonAddPet);
        petList = findViewById(R.id.rv_Pets);

        // Retrieving RecyclerView from layout and attaching a Layout Manager to it
        petList.hasFixedSize();
        petList.setLayoutManager(new LinearLayoutManager(this));

        // Attaching an adapter to the RecyclerView
        petAdapter = new PetAdapter();
        petList.setAdapter(petAdapter);


        //TODO: Måske skal den ikke starte en ny aktivitet når man vil tilføje et kæledyr. Burde måske gøres med et fragment i stedet for
        addPetButton.setOnClickListener(view -> {
            Intent intent = new Intent(ForsideActivity.this, AddPetActivity.class);
            startActivity(intent);
        });

    }
}