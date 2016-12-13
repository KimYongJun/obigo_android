package com.obigo.obigoproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.obigo.obigoproject.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by O BI HE ROCK on 2016-12-13.
 * 김용준, 최현욱
 */

public class MessageDetailActivity extends AppCompatActivity {
    @Bind(R.id.message_title)
    TextView _message_title;
    @Bind(R.id.message_content)
    TextView _message_content;
    @Bind(R.id.message_date)
    TextView _message_date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_detail);
        ButterKnife.bind(this);

    }

}