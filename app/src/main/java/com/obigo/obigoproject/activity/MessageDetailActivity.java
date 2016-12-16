package com.obigo.obigoproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.obigo.obigoproject.R;
import com.obigo.obigoproject.util.ConstantsUtil;
import com.obigo.obigoproject.vo.MessageVO;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by O BI HE ROCK on 2016-12-13.
 * 김용준, 최현욱
 */

public class MessageDetailActivity extends AppCompatActivity {

    @Bind(R.id.message_detail_title)
    TextView _message_detail_title;
    @Bind(R.id.message_detail_content)
    TextView _message_detail_content;
    @Bind(R.id.message_detail_date)
    TextView _message_detail_date;
    @Bind(R.id.message_detail_image)
    ImageView _message_detail_image;

    private MessageVO messageVO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        messageVO = (MessageVO) intent.getSerializableExtra("MessageDetailInfo");

        initVariable(messageVO);
    }


    // MessageDetail TextView, ImageView set해주기
    private void initVariable(MessageVO messageVO) {
        _message_detail_title.setText(messageVO.getTitle());
        _message_detail_content.setText(messageVO.getContent());
        _message_detail_date.setText(messageVO.getSendDate());
        Glide.with(this).load(ConstantsUtil.SERVER_API_URL_REAL + ConstantsUtil.SERVER_MESSAGE_IMAGE_URL +
                messageVO.getUploadFile()).into(_message_detail_image);
    }

}