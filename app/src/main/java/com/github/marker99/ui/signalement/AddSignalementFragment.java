package com.github.marker99.ui.signalement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.databinding.FragmentAddSignalementBinding;

public class AddSignalementFragment extends Fragment {

    private Button addButton;
    private EditText input_petName;
    private EditText input_birthday;
    private EditText input_race;
    private EditText input_gender;
    private EditText input_color;
    private EditText input_Characteristics;

    private FragmentAddSignalementBinding binding;
    private AddSignalementViewModel addSignalementViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        addSignalementViewModel = new ViewModelProvider(this).get(AddSignalementViewModel.class);
        binding = FragmentAddSignalementBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Binding stuff to things
        addButton = binding.addSignalement;
        input_petName = binding.editTextPetName;
        input_birthday = binding.editTextBirthdate;
        input_race = binding.editTextRace;
        input_gender = binding.editTextGender;
        input_color = binding.editTextColor;
        input_Characteristics = binding.editTextSpecialCharacteristics;

        // MOTHERFUCKING BUTTON
        addButton.setOnClickListener(this::addNewPet);

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_add_signalement, container, false);
        return root;
    }

    private void addNewPet(View view) {
        Pet newPet = new Pet(
                input_petName.getText().toString(),
                input_birthday.getText().toString(),
                input_race.getText().toString(),
                input_gender.getText().toString(),
                input_color.getText().toString(),
                input_Characteristics.getText().toString());
        addSignalementViewModel.insert(newPet);
    }

}