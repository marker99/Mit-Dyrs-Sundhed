package com.github.marker99.persistence.health_inspection;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.Database;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HealthInspectionRepository {

    private static HealthInspectionRepository instance;
    private final HealthInspectionDAO inspectionDAO;
    private final LiveData<List<HealthInspection>> allInspections;
    private final ExecutorService executorService;

    public HealthInspectionRepository(Application application) {
        Database database = Database.getInstance(application);
        inspectionDAO = database.inspectionDAO();
        allInspections = inspectionDAO.getAllInspections();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized HealthInspectionRepository getInstance(Application application) {
        if (instance == null)
            instance = new HealthInspectionRepository(application);
        return instance;
    }

    public LiveData<List<HealthInspection>> getAllInspections() {
        return allInspections;
    }

    public void insert(HealthInspection healthInspection) {
        executorService.execute(() -> inspectionDAO.insert(healthInspection));
    }

    public void deleteAllInspections(){
        executorService.execute(inspectionDAO::deleteAllInspections);
    }

}
