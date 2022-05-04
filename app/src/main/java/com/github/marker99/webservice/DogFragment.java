package com.github.marker99.webservice;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.marker99.databinding.DogFragmentBinding;

public class DogFragment extends Fragment {

    private DogFragmentBinding binding;
    private DogViewModelImpl dogViewModelImpl;

    private Button randomButton;
    private ImageView imageView;

    //Dog Data
    private TextView name, lifespan, temperament;

    private EditText breedNameSearch;
    private Button searchButton;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        dogViewModelImpl = new ViewModelProvider(this).get(DogViewModelImpl.class);

        binding = DogFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bindings();

        //Get a random dog when opening the view
        dogViewModelImpl.findRandomDog();

        observers();
        onClickListeners();


        return root;
    }

    private void onClickListeners() {
        searchButton.setOnClickListener(view -> {
            dogViewModelImpl.searchForBreed(breedNameSearch.getText().toString());
        });

        randomButton.setOnClickListener(view -> {
            dogViewModelImpl.findRandomDog();
        });
    }

    private void observers() {
        dogViewModelImpl.getRandomDog().observe(getViewLifecycleOwner(), dog -> {
            Glide.with(this).load(dog.getImageURL()).into(imageView);
            name.setText(dog.getName());
            lifespan.setText(dog.getLifeSpan());
            temperament.setText(dog.getTemperament());
        });
    }

    private void bindings() {
        breedNameSearch = binding.editTextBreedNameSearch;
        searchButton = binding.button;

        randomButton = binding.buttonRandom;
        imageView = binding.imageView;
        name = binding.textviewBreedName;
        lifespan = binding.textViewSetLifeSpan;
        temperament = binding.textViewSetTemperament;
    }

}