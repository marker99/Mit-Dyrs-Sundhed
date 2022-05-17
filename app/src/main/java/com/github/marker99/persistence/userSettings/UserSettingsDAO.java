package com.github.marker99.persistence.userSettings;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserSettingsDAO {
    @Insert
    void insert(UserSettings userSettings);

    @Update
    void update(UserSettings userSettings);

    @Query("SELECT * FROM userSettings_table WHERE id = 1")
    LiveData<UserSettings> getUserSettings();

}

