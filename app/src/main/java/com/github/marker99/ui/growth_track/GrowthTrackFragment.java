package com.github.marker99.ui.growth_track;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.marker99.databinding.FragmentGrowthTrackBinding;

public class GrowthTrackFragment extends Fragment {

    private FragmentGrowthTrackBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        GrowthTrackViewModelImpl viewModel = new ViewModelProvider(this).get(GrowthTrackViewModelImpl.class);

        binding = FragmentGrowthTrackBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}