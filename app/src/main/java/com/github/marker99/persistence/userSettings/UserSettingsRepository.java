package com.github.marker99.persistence.userSettings;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.Database;
import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.github.marker99.persistence.health_inspection.HealthInspectionDAO;
import com.github.marker99.persistence.health_inspection.HealthInspectionRepository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserSettingsRepository {

    private static UserSettingsRepository instance;
    private final UserSettingsDAO userSettingsDAO;
    private final ExecutorService executorService;

    public UserSettingsRepository(Application application) {
        Database database = Database.getInstance(application);
        userSettingsDAO = database.userSettingsDAO();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized UserSettingsRepository getInstance(Application application) {
        if (instance == null)
            instance = new UserSettingsRepository(application);
        return instance;
    }


    public LiveData<UserSettings> getUserSettings(){
        return userSettingsDAO.getUserSettings();
    }

    public void insert(UserSettings userSettings) {
        executorService.execute(() -> userSettingsDAO.insert(userSettings));
    }

    public void update(UserSettings userSettings){
        executorService.execute(() -> userSettingsDAO.update(userSettings));
    }

}
