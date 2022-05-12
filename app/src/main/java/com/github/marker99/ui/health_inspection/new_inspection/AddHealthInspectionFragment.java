package com.github.marker99.ui.health_inspection.new_inspection;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import com.github.marker99.persistence.DateConverter;
import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;

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

    //DATEPICKER
    MaterialDatePicker materialDatePicker;

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

        //SetUpMaterialDatePicker
        setUpDatePicker();

        //SetUpClickListener to MaterialDatePicker!
        setOnClickListeners();

        return root;
    }

    private void setOnClickListeners() {
        //OnClicker, so MaterialDatePicker pops up!
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //When clicked, the MaterialDatePicker shows up!
                materialDatePicker.show(getActivity().getSupportFragmentManager(), "test");

                //When accepting chosen date, display in view!
                materialDatePicker.addOnPositiveButtonClickListener(selection -> {
                    input_date.setText(DateConverter.fromLongToString((Long) selection));
                });
            }
        });
    }

    private void setUpDatePicker() {
        //Material Design
        //https://material.io/components/date-pickers/android#using-date-pickers

        //Setting calenderConstraints, so you can scroll to month after current!
        CalendarConstraints.Builder calenderConstraint = new CalendarConstraints.Builder();
        calenderConstraint.setEnd(MaterialDatePicker.todayInUtcMilliseconds());

        //Setting calenderConstraint validator, so a date beyond current date cannot be chosen!
        CalendarConstraints.DateValidator dateValidatorMax = DateValidatorPointBackward.before(MaterialDatePicker.todayInUtcMilliseconds());
        calenderConstraint.setValidator(dateValidatorMax);

        //Creating materialDatePicker
        materialDatePicker =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select date")
                        .setCalendarConstraints(calenderConstraint.build())
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
                        .build();
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

        //Health Inspection Information
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

        //DatePicker
        datePicker = binding.datePicker;
    }

}