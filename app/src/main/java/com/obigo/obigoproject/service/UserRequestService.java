package com.obigo.obigoproject.service;

import com.obigo.obigoproject.vo.UserRequestVO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by O BI HE ROCK on 2016-12-14
 * 김용준, 최현욱
 */

public interface UserRequestService {
    @POST("userrequest/")
    Call<String> insertUserRequest(@Body UserRequestVO userRequestVO);
}
