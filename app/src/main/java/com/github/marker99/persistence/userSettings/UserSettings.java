package com.github.marker99.persistence.userSettings;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userSettings_Table")
public class UserSettings {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int petId;

    public UserSettings(int petId) {
        this.petId = petId;
    }

    public int getId() {
        return id;
    }

    public int getPetId() {
        return petId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    @Override
    public String toString() {
        return "UserSettings{" +
                "id=" + id +
                ", petId=" + petId +
                '}';
    }
}
