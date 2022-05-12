package com.github.marker99.ui.signalement.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.marker99.databinding.FragmentSignalementBinding;

public class SignalementFragment extends Fragment {

    private TextView petName, birthDate, race, gender, color, characteristics;

    private FragmentSignalementBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SignalementViewModelImpl viewModel = new ViewModelProvider(this).get(SignalementViewModelImpl.class);

        binding = FragmentSignalementBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bindings();
        Bundle bundle = new Bundle();
        //Filling all the textViews
        //Integer.parseInt(bundle.getSerializable("petId").toString())
        viewModel.getSpecificPet().observe(getViewLifecycleOwner(), pet -> {
            //Tjekker om der er et pet i databasen, hvis der er tilføj data fra det!
            if (pet != null) {
                petName.setText(pet.getPetName());
                birthDate.setText(pet.getBirthday());
                race.setText(pet.getRace());
                gender.setText(pet.getGender());
                color.setText(pet.getColor());
                characteristics.setText(pet.getCharacteristics());
            }
        });


        return root;
    }

    // Binding stuff to things
    private void bindings() {
        petName = binding.textviewPetName;
        birthDate = binding.textviewBirthdate;
        race = binding.textviewRace;
        gender = binding.textviewGender;
        color = binding.textviewColor;
        characteristics = binding.textviewSpecialCharacteristics;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}