package com.github.marker99.ui.health_inspection;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.marker99.R;

public class AddHealthInspectionFragment extends Fragment {

    private AddHealthInspectionViewModel mViewModel;

    public static AddHealthInspectionFragment newInstance() {
        return new AddHealthInspectionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_health_inspection_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddHealthInspectionViewModel.class);
        // TODO: Use the ViewModel
    }

}