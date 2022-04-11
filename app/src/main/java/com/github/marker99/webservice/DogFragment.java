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

import com.bumptech.glide.Glide;
import com.github.marker99.R;
import com.github.marker99.databinding.DogFragmentBinding;

public class DogFragment extends Fragment {

    private DogFragmentBinding binding;

    DogViewModel dogViewModel;

    private Button randomButton;
    private ImageView imageView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        dogViewModel = new ViewModelProvider(this).get(DogViewModel.class);

        binding = DogFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bindings();

        dogViewModel.getSearchedDog().observe(getViewLifecycleOwner(), dog -> {
            Glide.with(this).load(dog.getImageURL()).into(imageView);
        });

        randomButton.setOnClickListener(view -> {
            dogViewModel.getRandomDog();
        });

        return root;
    }

    private void bindings() {
        randomButton = binding.buttonRandom;
        imageView = binding.imageView;
    }

}