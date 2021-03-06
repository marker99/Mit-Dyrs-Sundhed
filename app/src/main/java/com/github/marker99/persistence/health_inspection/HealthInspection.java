package com.github.marker99.persistence.health_inspection;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.github.marker99.persistence.DateHandler;

import java.io.Serializable;

@Entity(tableName = "healthInspection_table")
public class HealthInspection implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private long inspectionDate;
    private double weight;
    private String doctor, drinkingHabits, appetite;
    private String remarks, temper;
    private boolean eyes, outerEar, nose, oralCavity, navelGroin, skin_hairLayer,
            lymphNodes, pawClaws, heartLungs, sexualOrgans, milkLumps,
            joint;

    private int petId;

    public HealthInspection(long inspectionDate, String doctor, double weight, String drinkingHabits, String appetite,
                            boolean eyes, boolean outerEar, boolean nose,
                            boolean oralCavity, boolean navelGroin,
                            boolean skin_hairLayer, boolean lymphNodes, boolean pawClaws,
                            boolean heartLungs, boolean sexualOrgans, boolean milkLumps,
                            boolean joint, String remarks, String temper, int petId) {
        this.inspectionDate = inspectionDate;
        this.doctor = doctor;
        this.weight = weight;
        this.drinkingHabits = drinkingHabits;
        this.appetite = appetite;
        this.remarks = remarks;
        this.temper = temper;
        this.eyes = eyes;
        this.outerEar = outerEar;
        this.nose = nose;
        this.oralCavity = oralCavity;
        this.navelGroin = navelGroin;
        this.skin_hairLayer = skin_hairLayer;
        this.lymphNodes = lymphNodes;
        this.pawClaws = pawClaws;
        this.heartLungs = heartLungs;
        this.sexualOrgans = sexualOrgans;
        this.milkLumps = milkLumps;
        this.joint = joint;

        this.petId = petId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isNose() {
        return nose;
    }

    public void setNose(boolean nose) {
        this.nose = nose;
    }

    public boolean isJoint() {
        return joint;
    }

    public void setJoint(boolean joint) {
        this.joint = joint;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getInspectionDate() {
        return inspectionDate;
    }

    public String getInspectionDateStringFormat() {
        return DateHandler.fromLongToString(inspectionDate);
    }

    public void setInspectionDate(long inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public double getWeight() {
        return weight;
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

}