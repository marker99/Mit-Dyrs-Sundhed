package com.github.marker99.ui.health_inspection.recylerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import com.github.marker99.databinding.FragmentAllHealthInspectionsBinding;
import com.github.marker99.persistence.health_inspection.HealthInspection;

import java.util.List;

public class AllHealthInspectionsFragment extends Fragment {

    private Button button_addHealthInspection;
    private FragmentAllHealthInspectionsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AllHealthInspectionsViewModelImpl allHealthInspectionsViewModelImpl = new ViewModelProvider(this).get(AllHealthInspectionsViewModelImpl.class);

        binding = FragmentAllHealthInspectionsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bindings();
        onClickListeners();

        binding.rvHealthInspection.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));

        //Trying to make only specific petIds healthinspections
        SharedPreferences prefs = getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        int petId = prefs.getInt("petId", 2);
        Log.i("PetInfo", "PetId - AllHealthInspectionsFragment: " + petId);
        allHealthInspectionsViewModelImpl.findAllInspectionsWithPetId(petId);

        allHealthInspectionsViewModelImpl.getAllInspectionsWithPetId().observe(getViewLifecycleOwner(), this::onChanged);




        return root;
    }

    private void onClickListeners() {
        button_addHealthInspection.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_nav_healthInspection_to_addHealthInspectionFragment);
        });
    }

    private void bindings() {
        button_addHealthInspection = binding.buttonAddHealthInspection;
    }

    private void onChanged(List<HealthInspection> inspections){
        HealthInspectionAdapter adapter = new HealthInspectionAdapter(inspections);
        adapter.setOnClickListener(this::onInspectionClicked);
        binding.rvHealthInspection.setAdapter(adapter);
    }

    private void onInspectionClicked(HealthInspection healthInspection) {
        // Navigating to a different Fragment
        // Create a Bundle to send data
        Bundle bundle = new Bundle();
        // Fill bundle with Data
        bundle.putSerializable("inspectionDate", healthInspection);
        System.out.println(bundle.getSerializable("inspectionDate").toString());
        // Navigate with the bundle attached
        NavHostFragment.findNavController(this).navigate(R.id.action_nav_allHealthInspections_to_healthInspection, bundle);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}