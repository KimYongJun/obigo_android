package com.obigo.obigoproject.presenter;

import android.util.Log;

import com.obigo.obigoproject.service.ServiceManager;
import com.obigo.obigoproject.service.UserVehicleService;
import com.obigo.obigoproject.vo.UserVehicleVO;

import java.util.List;

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
    private List<UserVehicleVO> userVehicleList;

    public UserVehiclePresenter(String userId) {
        this.userVehicleService = ServiceManager.getInstance().getUserVehicleService();

        // userId 변경 요망
        this.userId = "ewqewq";
    }

    public void getUserVehicleList() {
        Log.i("userId : ", userId);
        userVehicleService.getUserVehicleList(userId).enqueue(new Callback<List<UserVehicleVO>>() {
            @Override
            public void onResponse(Call<List<UserVehicleVO>> call, Response<List<UserVehicleVO>> response) {
                userVehicleList = response.body();
                Log.i("user : ", userVehicleList.toString());
            }

            @Override
            public void onFailure(Call<List<UserVehicleVO>> call, Throwable t) {
                Log.i("에러 : ", t.getMessage());
            }
        });
    }
}
