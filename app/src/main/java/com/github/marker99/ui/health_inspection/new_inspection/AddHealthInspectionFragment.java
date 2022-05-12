package com.github.marker99.ui.health_inspection.new_inspection;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.github.marker99.R;
import com.github.marker99.databinding.FragmentAddHealthInspectionBinding;
import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.google.android.material.datepicker.MaterialDatePicker;

public class AddHealthInspectionFragment extends Fragment {

    private AddHealthInspectionViewModelImpl addHealthInspectionViewModelImpl;
    private FragmentAddHealthInspectionBinding binding;

    private Button addButton, datePicker;
    private EditText input_date, weight, doctor;
    private Spinner appetite, drinkingHabit, temper;
    private CheckBox eyes, outerEar, nose, oralCavity, navelGroin,
            skin_hairLayer, lymphNodes, pawClaws, heartLungs, sexualOrgans,
            milkLumps, joint;
    private EditText remarks;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        addHealthInspectionViewModelImpl = new ViewModelProvider(this).get(AddHealthInspectionViewModelImpl.class);
        binding = FragmentAddHealthInspectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //Binding stuff to things
        bindings();

        //Binding Data To Spinners
        spinnerAdapter();

        addButton.setOnClickListener(this::addNewHealthInspection);


        //Date picker! -- getView(), da vi er i fragment og ikke Activity.
        datePicker = binding.datePicker; //FIXME: Skal i bindings, når den virker!
/*

        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(AddHealthInspectionFragment.this,  //Your Fragment Class Name should be here, not getActivity(), or getContex().
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show(getActivity().getFragmentManager(), "DatePicker");

         */


        //FIXME: MaterialDatePicker - Jeg virker ikke i fragment
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Select a date");
        builder.setSelection(MaterialDatePicker.todayInUtcMilliseconds());
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Virker kun i Activities.. Skal lige have fundet en løsning
                //builder.build().show();
                //
            }
        });


        return root;
    }

    private void spinnerAdapter() {
        //FIXME: er der en smartere måde at lave en spinner?

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        appetite.setAdapter(adapter1);
        drinkingHabit.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_temper, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temper.setAdapter(adapter2);

    }

    private void addNewHealthInspection(View view) {
        SharedPreferences prefs = getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        int petId = prefs.getInt("petId", 0);
        Double weightD = 0.0;
        try {
            weightD = Double.parseDouble(weight.getText().toString());
        } catch (Exception e) {
        }
        HealthInspection newInspection = new HealthInspection(
                input_date.getText().toString(),
                doctor.getText().toString(),
                weightD,
                drinkingHabit.getSelectedItem().toString(),
                appetite.getSelectedItem().toString(),

                eyes.isChecked(),
                outerEar.isChecked(),
                nose.isChecked(),
                oralCavity.isChecked(),

                navelGroin.isChecked(),
                skin_hairLayer.isChecked(),
                lymphNodes.isChecked(),

                pawClaws.isChecked(),
                heartLungs.isChecked(),
                sexualOrgans.isChecked(),
                milkLumps.isChecked(),
                joint.isChecked(),

                remarks.getText().toString(),
                temper.getSelectedItem().toString(),
                petId
        );
        addHealthInspectionViewModelImpl.insert(newInspection);

        NavHostFragment.findNavController(this).navigate(R.id.nav_allHealthInspections);
    }

    private void bindings() {

        addButton = binding.addHealthInspection;
        input_date = binding.editTextInspectionDate;
        doctor = binding.editTextDoctor;
        weight = binding.editTextWeight;

        appetite = binding.spinnerAppetite;
        drinkingHabit = binding.spinnerDrinkingHabits;

        eyes = binding.checkboxEyes;
        outerEar = binding.checkboxOuterEar;
        nose = binding.checkboxNose;
        oralCavity = binding.checkboxOralCavity;
        navelGroin = binding.checkboxNavelGroin;
        skin_hairLayer = binding.checkboxSkinHairLayer;
        lymphNodes = binding.checkboxLymphNodes;
        pawClaws = binding.checkboxPawClaws;
        heartLungs = binding.checkboxHeartLungs;
        sexualOrgans = binding.checkboxSexualOrgans;
        milkLumps = binding.checkboxMilkLumps;
        joint = binding.checkboxJoint;

        remarks = binding.editTextRemarks;
        temper = binding.spinnerTemper;
    }

}