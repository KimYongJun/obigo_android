package com.obigo.obigoproject.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gregacucnik.EditTextView;
import com.obigo.obigoproject.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by O BI HE ROCK on 2016-12-06
 * 김용준, 최현욱
 * 차량 요청하는 페이지 - user_id, model_code, color, location, vin
 * API : /api/request
 * 차량 모델을 조회 - 송신 데이터 없음
 * API : /api/carmodellist
 * <p>
 * onClick method 호출 - 최현욱
 */

public class RequestActivity extends MenuActivity {

    @Bind(R.id.model_code)
    EditTextView code;
    @Bind(R.id.model_color)
    EditTextView color;
    @Bind(R.id.location)
    EditTextView location;
    @Bind(R.id.vin)
    EditTextView vin;

    @Bind(R.id.resetBtn)
    Button reset;
    @Bind(R.id.sendBtn)
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("REQUEST");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.request);

        final LinearLayout llContainer = (LinearLayout) findViewById(R.id.car_request);

        llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llContainer.requestFocus();
            }
        });

        ButterKnife.bind(this);
    }

    @OnClick(R.id.resetBtn)
    public void resetData() {
        code.setText("");
        color.setText("");
        location.setText("");
        vin.setText("");
    }

    @OnClick(R.id.sendBtn)
    public void requestUserCar() {
        Toast.makeText(getApplicationContext(),
                "code : " + code.getText().toString() + " , " + "color : " + color.getText().toString() +
                        " , " + "location : " + location.getText().toString() + " , " + "vin : " +
                        vin.getText().toString(), Toast.LENGTH_SHORT).show();
    }


}
