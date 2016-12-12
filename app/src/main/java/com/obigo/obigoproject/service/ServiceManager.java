package com.obigo.obigoproject.service;

/**
 * Created by O BI HE ROCK on 2016-12-07
 * 김용준, 최현욱
 */

public enum ServiceManager {
    INSTANCE;
    private LookService lookService;
    private UserVehicleService userVehicleService;

    ServiceManager() {
        lookService = RetrofitServiceGenericFactory.createService(LookService.class);
        userVehicleService = RetrofitServiceGenericFactory.createService(UserVehicleService.class);
    }

    public LookService getLookService() {
        return lookService;
    }

    public UserVehicleService getUserVehicleService() {
        return userVehicleService;
    }

    public static ServiceManager getInstance() {
        return INSTANCE;
    }
}
