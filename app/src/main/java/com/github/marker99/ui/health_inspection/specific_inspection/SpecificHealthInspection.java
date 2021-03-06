package com.github.marker99.ui.health_inspection.specific_inspection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.marker99.databinding.FragmentHealthInspectionBinding;
import com.github.marker99.persistence.health_inspection.HealthInspection;

public class SpecificHealthInspection extends Fragment {

    private TextView input_date, doctor, weight, appetite, drinkingHabit, temper, remarks;
    private CheckBox eyes, outerEar, nose, oralCavity, navelGroin,
            skin_hairLayer, lymphNodes, pawClaws, heartLungs, sexualOrgans,
            milkLumps, joint;

    private SpecificHealthInspectionViewModelImpl viewModel;
    private FragmentHealthInspectionBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(SpecificHealthInspectionViewModelImpl.class);

        binding = FragmentHealthInspectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Binding of fields
        bindings();

        HealthInspection healthInspection = (HealthInspection) getArguments().getSerializable("inspectionDate");
        viewModel.setInspection(healthInspection);

        populate(healthInspection);

        return root;
    }

    public void bindings() {
        input_date = binding.textViewInspectionDateData;
        doctor = binding.textViewDoctorData;
        weight = binding.textViewWeightData;
        appetite = binding.textviewAppetiteData;
        drinkingHabit = binding.textViewDrinkingHabitsData;
        temper = binding.textViewTemperData;
        remarks = binding.textViewRemarksData;

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
    }

    public void populate(HealthInspection healthInspection) {
        input_date.setText(healthInspection.getInspectionDateStringFormat());
        doctor.setText(healthInspection.getDoctor());
        weight.setText(String.valueOf(healthInspection.getWeight()));
        appetite.setText(healthInspection.getAppetite());
        drinkingHabit.setText(healthInspection.getDrinkingHabits());
        temper.setText(healthInspection.getTemper());
        remarks.setText(healthInspection.getRemarks());

        eyes.setChecked(healthInspection.isEyes());
        outerEar.setChecked(healthInspection.isOuterEar());
        nose.setChecked(healthInspection.isNose());
        oralCavity.setChecked(healthInspection.isOralCavity());
        navelGroin.setChecked(healthInspection.isNavelGroin());
        skin_hairLayer.setChecked(healthInspection.isSkin_hairLayer());
        lymphNodes.setChecked(healthInspection.isLymphNodes());
        pawClaws.setChecked(healthInspection.isPawClaws());
        heartLungs.setChecked(healthInspection.isHeartLungs());
        sexualOrgans.setChecked(healthInspection.isSexualOrgans());
        milkLumps.setChecked(healthInspection.isMilkLumps());
        joint.setChecked(healthInspection.isJoint());
    }


}