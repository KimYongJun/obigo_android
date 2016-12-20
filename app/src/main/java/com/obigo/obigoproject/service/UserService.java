package com.obigo.obigoproject.service;

import com.obigo.obigoproject.vo.RegistrationIdVO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by O BI HE ROCK on 2016-12-14
 * 김용준, 최현욱
 */

public interface UserService {
    // 특정 사용자 registrationId 저장
    @POST("registrationid/")
    Call<String> insertRegistrationId(@Body RegistrationIdVO registrationIdVO);
}
