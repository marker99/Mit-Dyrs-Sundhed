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

import com.github.marker99.R;
import com.github.marker99.databinding.FragmentHealthInspectionBinding;

public class HealthInspectionFragment extends Fragment {

    private Button button;
    private FragmentHealthInspectionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HealthInspectionViewModel healthInspectionViewModel =
                new ViewModelProvider(this).get(HealthInspectionViewModel.class);

        binding = FragmentHealthInspectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        button = binding.buttonAddHealthInspection;

        button.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_nav_healthInspection_to_addHealthInspectionFragment);
        });

       // final TextView textView = binding.;
       // healthInspectionViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}