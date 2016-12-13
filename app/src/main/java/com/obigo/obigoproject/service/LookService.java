package com.obigo.obigoproject.service;

import com.obigo.obigoproject.vo.UsersVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by O BI HE ROCK on 2016-12-12
 * 김용준, 최현욱
 * 아직 사용하지 않는 것 test 용
 */

public interface LookService {
//    @GET("looks/feed/{id}") Call<List<Look>> getLookList(@Path("id") String userId, @Query("pageNum") int pageNum);
//    @GET("looks/") Call<List<Look>> getMyLookList(@Query("userId") String userId, @Query("pageNum") int pageNum);

    @GET("api/user") Call<UsersVO> getLook(@Query("id") String id);
//    @POST("looks/") Call<String> createLook(@Body Look look);
//
//    @POST("looks/{id}/like") Call<Look> postLike(@Path("id") String lookId, @Query("userId") String userId);
//    @DELETE("looks/{id}/like") Call<Look> deleteLike(@Path("id") String lookId, @Query("userId") String userId);
//
//    @GET("looks/{id}/comment") Call<List<Comment>> getLookCommentList(@Path("id") String lookId);
//    @POST("looks/{id}/comment") Call<String> postComment(@Path("id") String lookId, @Body Comment comment);
//    @DELETE("looks/{id}/comment") Call<String> deleteComment(@Path("id") String lookId, @Body Comment comment);
}
