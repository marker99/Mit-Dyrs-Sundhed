package com.github.marker99.ui.home;

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
import com.github.marker99.databinding.FragmentHomeBinding;
import com.github.marker99.persistence.pet.Pet;

import java.util.List;

public class HomeFragment extends Fragment {

    private Button button_addPet;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bindings();
        onClickListeners();

        binding.rvAllPets.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        homeViewModel.getAllPets().observe(getViewLifecycleOwner(), this::onChanged);


        return root;
    }

    private void onClickListeners() {
        //Add new pet button
        button_addPet.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_nav_home_to_addPetInfoFragment);
        });
    }

    private void bindings() {
        //Alternative to findViewById in fragments!
        button_addPet = binding.buttonAddPetInfo;
    }

    private void onChanged(List<Pet> pets) {
        HomePetsAdapter adapter = new HomePetsAdapter(pets);
        adapter.setOnClickListener(this::onPetClicked);
        binding.rvAllPets.setAdapter(adapter);
    }

    private void onPetClicked(Pet pet) {
        // Navigating to a different Fragment
        // Create a Bundle to send data
        Bundle bundle = new Bundle();
        // Fill bundle with Data
        bundle.putSerializable("petName", pet);
        System.out.println(bundle.getSerializable("petName").toString());
        // Navigate with the bundle attached
        NavHostFragment.findNavController(this).navigate(R.id.action_nav_home_to_petSignalement, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}