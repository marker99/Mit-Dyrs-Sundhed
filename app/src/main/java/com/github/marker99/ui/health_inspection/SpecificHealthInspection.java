package com.github.marker99.ui.health_inspection;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.marker99.databinding.FragmentHealthInspectionBinding;
import com.github.marker99.persistence.health_inspection.HealthInspection;

public class SpecificHealthInspection extends Fragment {

    private TextView test;

    private SpecificHealthInspectionViewModel viewModel;
    private FragmentHealthInspectionBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(SpecificHealthInspectionViewModel.class);

        binding = FragmentHealthInspectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bindings();

        if (getArguments() != null) {
            System.out.println(getArguments().isEmpty());
        } else {
            System.out.println("There was nothing in the bundle");
        }

        HealthInspection healthInspection = (HealthInspection) getArguments().getSerializable("inspectionDate");
        viewModel.setInspection(healthInspection);

        populate(healthInspection);


        return root;
    }

    public void populate(HealthInspection healthInspection) {
        test.setText(healthInspection.getInspectionDate().toString());
    }


    public void bindings() {
        test = binding.textViewTest;

    }


}