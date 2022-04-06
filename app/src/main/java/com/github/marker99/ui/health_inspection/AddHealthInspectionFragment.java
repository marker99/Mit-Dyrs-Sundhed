package com.github.marker99.ui.health_inspection;

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

import com.github.marker99.R;
import com.github.marker99.databinding.FragmentAddHealthInspectionBinding;
import com.github.marker99.persistence.health_inspection.HealthInspection;

public class AddHealthInspectionFragment extends Fragment {

    private AddHealthInspectionViewModel addHealthInspectionViewModel;
    private FragmentAddHealthInspectionBinding binding;

    private Button addButton;
    private EditText input_date;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        addHealthInspectionViewModel = new ViewModelProvider(this).get(AddHealthInspectionViewModel.class);
        binding = FragmentAddHealthInspectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Binding stuff to things
        addButton = binding.addHealthInspection;
        input_date = binding.editTextInspectionDate;

        addButton.setOnClickListener(this::addNewHealthInspection);

        return root;
    }

    private void addNewHealthInspection(View view) {
        HealthInspection newInspection = new HealthInspection(
                input_date.getText().toString());
        addHealthInspectionViewModel.insert(newInspection);
    }

}