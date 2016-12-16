package com.obigo.obigoproject.presenter;

import android.util.Log;
import android.widget.ListView;

import com.obigo.obigoproject.R;
import com.obigo.obigoproject.activity.MessageActivity;
import com.obigo.obigoproject.adapter.MessageListAdapter;
import com.obigo.obigoproject.service.MessageService;
import com.obigo.obigoproject.service.ServiceManager;
import com.obigo.obigoproject.vo.MessageVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by O BI HE ROCK on 2016-12-14
 * 김용준, 최현욱
 */

public class MessagePresenter {
    private ListView listView;
    private MessageListAdapter objAdapter;
    private MessageService messageService;
    private MessageActivity messageActivity;
    private List<MessageVO> messageList;
    private String userId;

    public MessagePresenter(MessageActivity messageActivity, String userId, ListView listView) {
        this.listView = listView;
        this.messageActivity = messageActivity;
        this.messageService = ServiceManager.getInstance().getMessageService();
        this.userId = userId;
    }

    public void getMessageList() {
        Log.i("userId  : ", userId);
        Call<List<MessageVO>> call = messageService.getMessageList(userId);
        call.enqueue(new Callback<List<MessageVO>>() {
            @Override
            public void onResponse(Call<List<MessageVO>> call, Response<List<MessageVO>> response) {
                if (response.isSuccessful()) {
                    messageList = response.body();
                    Log.i("user : ", MessagePresenter.this.messageList.toString());
                    objAdapter = new MessageListAdapter(messageActivity,
                            R.layout.message_item, messageList);
                    messageActivity.dispatchMessageInfo(messageList);
                    listView.setAdapter(objAdapter);
                } else {
                    Log.i("error : ", response.errorBody().toString());
                }

            }
            @Override
            public void onFailure(Call<List<MessageVO>> call, Throwable t) {
                Log.i("에러 : ", t.getMessage());
            }
        });
    }
}
