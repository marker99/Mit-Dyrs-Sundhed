package com.github.marker99.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class HomeFragment extends Fragment {

    private Button button_addPet;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModelImpl homeViewModelImpl =
                new ViewModelProvider(this).get(HomeViewModelImpl.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bindings();
        onClickListeners();

        binding.rvAllPets.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        homeViewModelImpl.getAllPets().observe(getViewLifecycleOwner(), this::onChanged);


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
        //Save SharedPreference on Pet, so it can be accessed all over the project! HealthInspections + Signalament
        SharedPreferences prefs = getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("petId", pet.getId());
        editor.putString("petName", pet.getPetName());
        editor.apply();

        //Snackbar to display which pet is selected!
        Snackbar.make(getView(), pet.getPetName() + " selected", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}