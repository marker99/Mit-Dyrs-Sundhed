package com.github.marker99.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.github.marker99.databinding.SettingsFragmentBinding;

public class SettingsFragment extends Fragment {

    private Button signOutButton;
    private TextView userIdText;

    private SettingsFragmentBinding binding;
    private SettingsViewModel settingsViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = SettingsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bindings();
        checkIfSignedIn();

        signOutButton.setOnClickListener(view -> {
            settingsViewModel.signOut();
        });

        return root;
    }

    private void checkIfSignedIn() {
        settingsViewModel.getCurrentUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                String message = "User: " + user.getDisplayName();
                userIdText.setText(message);
            }
        });
    }

    private void bindings() {
        signOutButton = binding.signOutButton;
        userIdText = binding.userText;
    }


}