package com.github.marker99.ui.find_your_dog;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.github.marker99.databinding.FragmentFindYourNewDogBinding;

public class DogFragment extends Fragment {

    private FragmentFindYourNewDogBinding binding;
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

        binding = FragmentFindYourNewDogBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        /*
        root.setFocusable(true);
        root.setFocusableInTouchMode(true);
        root.setClickable(true);

         */

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