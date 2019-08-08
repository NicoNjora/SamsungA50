package com.nicolletnjora.samsunga50.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UssdCode {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String ussdCodePath;
    private String ussdCodePathDescription;
    private String serviceProvider;
    private String serviceType;

    public UssdCode(int id, String ussdCodePath, String ussdCodePathDescription, String serviceProvider, String serviceType) {
        this.id = id;
        this.ussdCodePath = ussdCodePath;
        this.ussdCodePathDescription = ussdCodePathDescription;
        this.serviceProvider = serviceProvider;
        this.serviceType = serviceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUssdCodePath() {
        return ussdCodePath;
    }

    public void setUssdCodePath(String ussdCodePath) {
        this.ussdCodePath = ussdCodePath;
    }

    public String getUssdCodePathDescription() {
        return ussdCodePathDescription;
    }

    public void setUssdCodePathDescription(String ussdCodePathDescription) {
        this.ussdCodePathDescription = ussdCodePathDescription;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
