package com.obigo.obigoproject.presenter;

import android.util.Log;

import com.obigo.obigoproject.activity.RequestActivity;
import com.obigo.obigoproject.service.ServiceManager;
import com.obigo.obigoproject.service.UserRequestService;
import com.obigo.obigoproject.vo.UserRequestVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by O BI HE ROCK on 2016-12-14
 * 김용준, 최현욱
 */

public class UserRequestPresenter {
    private UserRequestService userRequestService;
    private RequestActivity requestActivity;

    public UserRequestPresenter(RequestActivity requestActivity) {
        this.requestActivity = requestActivity;
        userRequestService = ServiceManager.getInstance().getUserRequestService();
    }

    public void insertUserRequest(UserRequestVO userRequestVO) {
        Log.i("userRequest : ", userRequestVO.toString());
        Call<String> call = userRequestService.insertUserRequest(userRequestVO);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Log.i("qwe : ", "qwe");
                } else {
                    Log.i("error : ", response.errorBody().toString());
                }

            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("에러 : ", t.getMessage());
            }
        });
    }
}
