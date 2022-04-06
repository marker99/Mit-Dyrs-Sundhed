package com.github.marker99.ui.health_inspection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.github.marker99.R;
import com.github.marker99.databinding.FragmentHealthInspectionBinding;
import com.github.marker99.persistence.health_inspection.HealthInspection;

import java.util.List;

public class HealthInspectionFragment extends Fragment {

    private Button button;
    private FragmentHealthInspectionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HealthInspectionViewModel healthInspectionViewModel = new ViewModelProvider(this).get(HealthInspectionViewModel.class);

        binding = FragmentHealthInspectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        button = binding.buttonAddHealthInspection;

        button.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_nav_healthInspection_to_addHealthInspectionFragment);
        });


        binding.rvHealthInspection.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        healthInspectionViewModel.getAllInspections().observe(getViewLifecycleOwner(), this::onChanged);

        return root;
    }

    private void onChanged(List<HealthInspection> inspections){
        HealthInspectionAdapter adapter = new HealthInspectionAdapter(inspections);
        binding.rvHealthInspection.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}