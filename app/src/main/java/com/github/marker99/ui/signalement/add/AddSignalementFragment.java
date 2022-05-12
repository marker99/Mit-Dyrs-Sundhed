package com.github.marker99.ui.signalement.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.github.marker99.R;
import com.github.marker99.databinding.FragmentAddSignalementBinding;
import com.github.marker99.persistence.DateHandler;
import com.github.marker99.persistence.pet.Pet;
import com.google.android.material.datepicker.MaterialDatePicker;

public class AddSignalementFragment extends Fragment {

    private Button addButton, button_birthday;
    private TextView textView_bday;
    private EditText input_petName, input_race;
    private EditText input_gender, input_color, input_Characteristics;

    private FragmentAddSignalementBinding binding;
    private AddSignalementViewModelImpl addSignalementViewModelImpl;

    //MaterialDatePicker
    private MaterialDatePicker materialDatePicker;
    private long dateChosen;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        addSignalementViewModelImpl = new ViewModelProvider(this).get(AddSignalementViewModelImpl.class);
        binding = FragmentAddSignalementBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //get Material Date Picker from DateConverter!
        materialDatePicker = DateHandler.getMaterialDatePicker();
        bindings();

        onClickListeners();

        return root;
    }

    private void onClickListeners() {
        // Button on click listener
        addButton.setOnClickListener(this::addNewPet);

        //MaterialDatePicker Listener
        button_birthday.setOnClickListener(view -> {
            //When clicked, the MaterialDatePicker shows up!
            materialDatePicker.show(getActivity().getSupportFragmentManager(), "test");

            //When accepting chosen date, display in view!
            materialDatePicker.addOnPositiveButtonClickListener(selection -> {
                dateChosen = (Long) selection;
                textView_bday.setText(DateHandler.fromLongToString((Long) selection));
            });
        });
    }

    private void addNewPet(View view) {
        Pet newPet = new Pet(
                input_petName.getText().toString(),
                dateChosen,
                input_race.getText().toString(),
                input_gender.getText().toString(),
                input_color.getText().toString(),
                input_Characteristics.getText().toString());
        addSignalementViewModelImpl.insert(newPet);
        NavHostFragment.findNavController(this).navigate(R.id.nav_home);
    }

    // Binding stuff to things
    private void bindings() {
        button_birthday = binding.buttonBirthday;
        addButton = binding.addSignalement;
        input_petName = binding.editTextPetName;
        textView_bday = binding.textViewBirthdate;
        input_race = binding.editTextRace;
        input_gender = binding.editTextGender;
        input_color = binding.editTextColor;
        input_Characteristics = binding.editTextSpecialCharacteristics;
    }

}