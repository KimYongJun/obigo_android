package com.obigo.obigoproject.presenter;

import android.util.Log;

import com.obigo.obigoproject.activity.LoginActivity;
import com.obigo.obigoproject.service.ServiceManager;
import com.obigo.obigoproject.service.UserService;
import com.obigo.obigoproject.vo.RegistrationIdVO;
import com.obigo.obigoproject.vo.UserVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by O BI HE ROCK on 2016-12-14
 * 김용준, 최현욱
 */

public class UserPresenter {
    // 사용자 서비스 요청
    private UserService userService;

    private LoginActivity loginActivity;
    private boolean registrationIdResult;
    private String userId;
    private UserVO userVO;

    public UserPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        userService = ServiceManager.getInstance().getUserService();
    }

    public void insertRegistrationId(RegistrationIdVO registrationIdVO) {
        Log.i("registrationIdVO : ", registrationIdVO.toString());
        Call<String> call = userService.insertRegistrationId(registrationIdVO);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Log.i("response : ", response.body().toString());
                }
            }

            // 서버와 접속 실패
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("에러 : ", t.getMessage());
            }
        });
    }

    public void getUser(){
        Log.i("userId  : ", userId);
        Call<UserVO> call = userService.getUser(userId);
        call.enqueue(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                if (response.isSuccessful()) {
                    userVO = response.body();
                    Log.i("user : ", UserPresenter.this.userVO.toString());
                   // userInfoActivity.dispatchUserInfo(userVO);

                } else {
                    Log.i("error : ", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<UserVO> call, Throwable t) {
                Log.i("error : ", t.getMessage());
            }
        });
    }
}
