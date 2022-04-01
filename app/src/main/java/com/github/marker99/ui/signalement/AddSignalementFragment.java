package com.github.marker99.ui.signalement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.github.marker99.Pet;
import com.github.marker99.R;

public class AddSignalementFragment extends Fragment {

    Button addButton;
    EditText input_petName;
    EditText input_birthday;
    EditText input_race;
    EditText input_gender;
    EditText input_color;
    EditText input_Characteristics;

    private AddSignalementViewModel addSignalementViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        addButton.findViewById(R.id.addSignalement);
        input_petName.findViewById(R.id.editText_petName);
        input_birthday.findViewById(R.id.editText_birthdate);
        input_race.findViewById(R.id.editText_race);
        input_gender.findViewById(R.id.editText_color);
        input_color.findViewById(R.id.editText_color);
        input_Characteristics.findViewById(R.id.editText_specialCharacteristics);

        addButton.setOnClickListener(view -> {
            addSignalementViewModel.insert(new Pet(input_petName.getText().toString(),
                    input_birthday.getText().toString(), input_race.getText().toString(),
                    input_gender.getText().toString(), input_color.getText().toString(),
                    input_Characteristics.getText().toString()));
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_signalement, container, false);
    }

}