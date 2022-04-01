package com.github.marker99.ui.signalement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.marker99.databinding.FragmentSignalementBinding;

public class SignalementFragment extends Fragment {

    private FragmentSignalementBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SignalementViewModel signalementViewModel =
                new ViewModelProvider(this).get(SignalementViewModel.class);

        binding = FragmentSignalementBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView textView = binding.textviewPetName;
        signalementViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}