package com.obigo.obigoproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.obigo.obigoproject.R;
import com.obigo.obigoproject.adapter.MessageListAdapter;
import com.obigo.obigoproject.vo.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by O BI HE ROCK on 2016-12-01
 * 김용준, 최현욱
 * 메시지 리스트를 보여주는 페이지 - user_id, page_index
 * scroll, add_button 구현 예정
 */

public class MessageActivity extends MenuActivity implements OnItemClickListener {
    // 메시지 List
    List<Message> messageList;
    // 메지시 리스트 뷰
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTitle("MESSAGE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_list);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);

        messageList = new ArrayList<Message>();

        Date date = new Date();

        for (int i = 0; i <= 25; i++) {
            messageList.add(new Message(1, "이것은 오비고 테스트입니다! 이것은 오비고 테스트입니다!이것은 오비고 테스트입니다!", "이것은 오비고 content입니다!!! 이것은 오비고 content입니다!!!" +
                    " 이것은 오비고 content입니다!!! 이것은 오비고 content입니다!!!", date.toString(), "@drawable/message_test"));
        }

        setAdapterToListview();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Message message = messageList.get(position);
        Intent intent = new Intent(MessageActivity.this, MessageDetailActivity.class); // 세부사항
        Log.d("값 : ", message.toString());
        intent.putExtra("Message", message);
        startActivity(intent);
    }

    public void setAdapterToListview() {
        MessageListAdapter objAdapter = new MessageListAdapter(MessageActivity.this,
                R.layout.message_item, messageList);
        listView.setAdapter(objAdapter);
    }
}
