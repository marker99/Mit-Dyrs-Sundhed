package com.github.marker99.persistence.health_inspection;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "healthInspection_table")
public class HealthInspection implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String inspectionDate; //Date objects i stedet?
    private int weight;
    private String drinkingHabits, appetite;
    private String remarks, temper, laboratoryTests;
    private boolean eyes, outerEar, oralCavity, navelGroin, skin_hairLayer,
            lymphNodes, pawClaws, heartLungs, sexualOrgans, milkLumps, analLumps,
            posture_movements;

    public HealthInspection(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDrinkingHabits() {
        return drinkingHabits;
    }

    public void setDrinkingHabits(String drinkingHabits) {
        this.drinkingHabits = drinkingHabits;
    }

    public String getAppetite() {
        return appetite;
    }

    public void setAppetite(String appetite) {
        this.appetite = appetite;
    }

    public boolean isEyes() {
        return eyes;
    }

    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    public boolean isOuterEar() {
        return outerEar;
    }

    public void setOuterEar(boolean outerEar) {
        this.outerEar = outerEar;
    }

    public boolean isOralCavity() {
        return oralCavity;
    }

    public void setOralCavity(boolean oralCavity) {
        this.oralCavity = oralCavity;
    }

    public boolean isNavelGroin() {
        return navelGroin;
    }

    public void setNavelGroin(boolean navelGroin) {
        this.navelGroin = navelGroin;
    }

    public boolean isSkin_hairLayer() {
        return skin_hairLayer;
    }

    public void setSkin_hairLayer(boolean skin_hairLayer) {
        this.skin_hairLayer = skin_hairLayer;
    }

    public boolean isLymphNodes() {
        return lymphNodes;
    }

    public void setLymphNodes(boolean lymphNodes) {
        this.lymphNodes = lymphNodes;
    }

    public boolean isPawClaws() {
        return pawClaws;
    }

    public void setPawClaws(boolean pawClaws) {
        this.pawClaws = pawClaws;
    }

    public boolean isHeartLungs() {
        return heartLungs;
    }

    public void setHeartLungs(boolean heartLungs) {
        this.heartLungs = heartLungs;
    }

    public boolean isSexualOrgans() {
        return sexualOrgans;
    }

    public void setSexualOrgans(boolean sexualOrgans) {
        this.sexualOrgans = sexualOrgans;
    }

    public boolean isMilkLumps() {
        return milkLumps;
    }

    public void setMilkLumps(boolean milkLumps) {
        this.milkLumps = milkLumps;
    }

    public boolean isAnalLumps() {
        return analLumps;
    }

    public void setAnalLumps(boolean analLumps) {
        this.analLumps = analLumps;
    }

    public boolean isPosture_movements() {
        return posture_movements;
    }

    public void setPosture_movements(boolean posture_movements) {
        this.posture_movements = posture_movements;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper;
    }

    public String getLaboratoryTests() {
        return laboratoryTests;
    }

    public void setLaboratoryTests(String laboratoryTests) {
        this.laboratoryTests = laboratoryTests;
    }

}