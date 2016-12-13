package com.obigo.obigoproject.presenter;

import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.obigo.obigoproject.service.LookService;
import com.obigo.obigoproject.service.ServiceManager;
import com.obigo.obigoproject.vo.UsersVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import style.dots.Dots.models.Look;
//import style.dots.Dots.ui.fragments.LookFragment;
//import style.dots.Dots.utils.PreferenceManager;

/**
 * Created by O BI HE ROCK on 2016-12-07
 * 김용준, 최현욱
 * 아직 사용하지 않는 것 test 용
 */

public class LookPresenter {
    //    private LookFragment view;
    private LookService lookService;

    private String id;
    @SerializedName("")
    private UsersVO user;

    public LookPresenter(String id) {
//        this.view = view; 앞부분에 들어갈 내용(파라미터) LookFragment view,
        this.lookService = ServiceManager.getInstance().getLookService();
        this.id = "qweqwe";
    }

    public void getLook() {
//        view.showLoadingMessage();
        Log.i("id : ", id);
        lookService.getLook(id).enqueue(new Callback<UsersVO>() {
            @Override
            public void onResponse(Call<UsersVO> call, Response<UsersVO> response) {
//                view.hideLoadingMessage();
                user = response.body();
                Log.i("user : ", user.toString());
//                view.displaySet(response.body());
            }

            @Override
            public void onFailure(Call<UsersVO> call, Throwable t) {
                Log.i("에러 : ", t.getMessage());
//                view.hideLoadingMessage();
//                view.showFailMessage();
            }
        });
    }
}
/*
    public void clickLike() {
        String userId = PreferenceManager.getAuthInfo(view.getContext()).getUserId();
        if (look.getLikeUsers() != null && look.getLikeUsers().contains(userId)) {
            deleteLike();
        } else {
            postLike();
        }
    }

    private void postLike() {
        String lookId = look.get_id();
        String userId = PreferenceManager.getAuthInfo(view.getContext()).getUserId();
        lookService.postLike(lookId, userId).enqueue(new Callback<Look>() {
            @Override
            public void onResponse(Call<Look> call, Response<Look> response) {
                look = response.body();
                view.updateLikeCount(response.body());
            }
            @Override
            public void onFailure(Call<Look> call, Throwable t) {
                view.showFailMessage();
            }
        });
    }

    private void deleteLike() {
        String lookId = look.get_id();
        String userId = PreferenceManager.getAuthInfo(view.getContext()).getUserId();
        lookService.deleteLike(lookId, userId).enqueue(new Callback<Look>() {
            @Override
            public void onResponse(Call<Look> call, Response<Look> response) {
                look = response.body();
                view.updateLikeCount(response.body());
            }
            @Override
            public void onFailure(Call<Look> call, Throwable t) {
                view.showFailMessage();
            }
        });
    }
}
*/