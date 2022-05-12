package com.github.marker99.ui.signalement.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.github.marker99.R;
import com.github.marker99.databinding.FragmentAddSignalementBinding;
import com.github.marker99.persistence.pet.Pet;

public class AddSignalementFragment extends Fragment {

    private Button addButton;
    private EditText input_petName, input_birthday, input_race;
    private EditText input_gender, input_color, input_Characteristics;

    private FragmentAddSignalementBinding binding;
    private AddSignalementViewModelImpl addSignalementViewModelImpl;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        addSignalementViewModelImpl = new ViewModelProvider(this).get(AddSignalementViewModelImpl.class);
        binding = FragmentAddSignalementBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bindings();

        // Button on click listener
        addButton.setOnClickListener(this::addNewPet);

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
        addSignalementViewModelImpl.insert(newPet);
        NavHostFragment.findNavController(this).navigate(R.id.nav_home);
    }

    // Binding stuff to things
    private void bindings() {
        addButton = binding.addSignalement;
        input_petName = binding.editTextPetName;
        input_birthday = binding.editTextBirthdate;
        input_race = binding.editTextRace;
        input_gender = binding.editTextGender;
        input_color = binding.editTextColor;
        input_Characteristics = binding.editTextSpecialCharacteristics;
    }

}