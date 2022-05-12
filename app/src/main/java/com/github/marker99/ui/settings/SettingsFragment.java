package com.github.marker99.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.marker99.databinding.SettingsFragmentBinding;

public class SettingsFragment extends Fragment {

    private Button signOutButton;
    private TextView userIdText;

    private SettingsFragmentBinding binding;
    private SettingsViewModelImpl settingsViewModelImpl;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        settingsViewModelImpl = new ViewModelProvider(this).get(SettingsViewModelImpl.class);

        binding = SettingsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bindings();
        checkIfSignedIn();
        onClickListeners();

        return root;
    }

    private void onClickListeners() {
        signOutButton.setOnClickListener(view -> {
            settingsViewModelImpl.signOut();
        });
    }

    private void checkIfSignedIn() {
        settingsViewModelImpl.getCurrentUser().observe(getViewLifecycleOwner(), user -> {
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