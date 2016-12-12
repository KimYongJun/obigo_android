package com.obigo.obigoproject.presenter;

import android.util.Log;

import com.obigo.obigoproject.service.ServiceManager;
import com.obigo.obigoproject.service.UserVehicleService;
import com.obigo.obigoproject.vo.UserVehicleList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by O BI HE ROCK on 2016-12-12
 * 김용준, 최현욱
 */

public class UserVehiclePresenter {
    private UserVehicleService userVehicleService;
    private String userId;
    private UserVehicleList userVehicleList;

    public UserVehiclePresenter(String userId) {
        this.userVehicleService = ServiceManager.getInstance().getUserVehicleService();

        // userId 변경 요망
        this.userId = "ewqewq";

    }

    public UserVehicleList getUserVehicleList() {
        Log.i("userId : ", userId);
        userVehicleService.getUserVehicleList(userId).enqueue(new Callback<UserVehicleList>() {
            @Override
            public void onResponse(Call<UserVehicleList> call, Response<UserVehicleList> response) {
                userVehicleList = response.body();
                Log.i("user : ", response.body().toString());
            }

            @Override
            public void onFailure(Call<UserVehicleList> call, Throwable t) {
                Log.i("에러 : ", t.getMessage());
            }
        });
        return null;
    }
}
