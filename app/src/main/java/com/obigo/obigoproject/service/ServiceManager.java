package com.obigo.obigoproject.service;

/**
 * Created by O BI HE ROCK on 2016-12-07
 * 김용준, 최현욱
 */

public enum ServiceManager {
    INSTANCE;
    private UserVehicleService userVehicleService;

    ServiceManager() {
        userVehicleService = RetrofitServiceGenericFactory.createService(UserVehicleService.class);
    }

    public UserVehicleService getUserVehicleService() {
        return userVehicleService;
    }

    public static ServiceManager getInstance() {
        return INSTANCE;
    }
}
