package com.github.marker99.ui.health_inspection.new_inspection;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.github.marker99.databinding.FragmentAddHealthInspectionBinding;
import com.github.marker99.persistence.health_inspection.HealthInspection;

public class AddHealthInspectionFragment extends Fragment {

    private AddHealthInspectionViewModel addHealthInspectionViewModel;
    private FragmentAddHealthInspectionBinding binding;

    private Button addButton;
    private EditText input_date, weight;
    private Spinner appetite, drinkingHabit;
    private CheckBox eyes, outerEar, nose, oralCavity, navelGroin,
            skin_hairLayer, lymphNodes, pawClaws, heartLungs, sexualOrgans,
            milkLumps, analLumps, joint, postureMovements;
    private EditText remarks, temper, laboratoryTests;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        addHealthInspectionViewModel = new ViewModelProvider(this).get(AddHealthInspectionViewModel.class);
        binding = FragmentAddHealthInspectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Binding stuff to things
        bindings();

        addButton.setOnClickListener(this::addNewHealthInspection);

        return root;
    }

    private void addNewHealthInspection(View view) {
        HealthInspection newInspection = new HealthInspection(
                input_date.getText().toString());
        addHealthInspectionViewModel.insert(newInspection);
    }

    private void bindings()
    {
        addButton = binding.addHealthInspection;
        input_date = binding.editTextInspectionDate;
        weight = binding.editTextWeight;

        appetite = binding.spinnerAppetite;
        drinkingHabit = binding.spinnerDrinkingHabits;

        eyes = binding.checkboxEyes;
        outerEar = binding.checkboxOuterEar;
        nose = binding.checkboxNose;
        oralCavity = binding.checkboxOralCavity;
        navelGroin = binding.checkboxNavelGroin;
        skin_hairLayer = binding.checkboxSkinHairLayer;
        lymphNodes = binding.checkboxLymphNodes;
        pawClaws = binding.checkboxPawClaws;
        heartLungs = binding.checkboxHeartLungs;
        sexualOrgans = binding.checkboxSexualOrgans;
        milkLumps = binding.checkboxMilkLumps;
        analLumps = binding.checkboxAnalLumps;
        joint = binding.checkboxJoint;
        postureMovements = binding.checkboxPostureMovements;

        remarks = binding.editTextRemarks;
        temper = binding.editTextRemarks;
        laboratoryTests = binding.editTextLaboratoryTests;
    }

}