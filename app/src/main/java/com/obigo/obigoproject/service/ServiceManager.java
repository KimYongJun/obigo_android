package com.obigo.obigoproject.service;

public enum ServiceManager {
    INSTANCE;
    private LookService lookService;

    ServiceManager() {
        lookService = RetrofitServiceGenericFactory.createService(LookService.class);
    }

    public LookService getLookService() {
        return lookService;
    }

    public static ServiceManager getInstance() {
        return INSTANCE;
    }
}
