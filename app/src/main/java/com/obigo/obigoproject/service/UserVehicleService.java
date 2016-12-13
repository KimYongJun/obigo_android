package com.obigo.obigoproject.service;

import com.obigo.obigoproject.vo.UserVehicleVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by O BI HE ROCK on 2016-12-12
 * 김용준, 최현욱
 */

public interface UserVehicleService {
    @GET("api/uservehicle/{userid}")
    Call<List<UserVehicleVO>> getUserVehicleList(@Path("userid") String userId);
}
