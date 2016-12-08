package com.obigo.obigoproject.service;

import com.obigo.obigoproject.util.ConstantsUtil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceGenericFactory {
    public static <T> T createService(Class<T> serviceClass) {
        return getRetofitObject().create(serviceClass);
    }

    private static Retrofit getRetofitObject() {
        return
                new Retrofit.Builder()
                        .baseUrl(ConstantsUtil.SERVER_API_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
    }
}
