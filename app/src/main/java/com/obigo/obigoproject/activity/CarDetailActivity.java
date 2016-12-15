package com.obigo.obigoproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.obigo.obigoproject.R;
import com.obigo.obigoproject.vo.UserVehicleVO;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by O BI HE ROCK on 2016-12-13
 * 김용준, 최현욱
 */

public class CarDetailActivity extends AppCompatActivity {
    @Bind(R.id.detail_image) ImageView carDetailImage;
    @Bind(R.id.detail_model_name) TextView modelNameTextView;
    @Bind(R.id.detail_model_code) TextView modelCodeTextView;
    @Bind(R.id.detail_model_year) TextView modelYearTextView;
    @Bind(R.id.detail_engine) TextView engineTextView;
    @Bind(R.id.detail_vin) TextView vinTextView;
    @Bind(R.id.detail_model_color) TextView colorTextView;
    @Bind(R.id.detail_location) TextView locationTextView;
    @Bind(R.id.detail_mileage) TextView mileageTextView;
    @Bind(R.id.detail_active_dtc_count) TextView activeDtcCountTextView;

    private UserVehicleVO userVehicleVO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        userVehicleVO = (UserVehicleVO) intent.getSerializableExtra("carDetailInfo");

        initVariable();
    }

    private void initVariable() {
        Glide.with(this).load("http://192.168.1.14/obigoProject/api/image/vehicle/94587474604170img_visual_car.png").into(carDetailImage);

        modelNameTextView.setText(userVehicleVO.getModelName());
        modelCodeTextView.setText(userVehicleVO.getModelCode());
        modelYearTextView.setText(Integer.toString(userVehicleVO.getModelYear()));
        engineTextView.setText(userVehicleVO.getEngine());
        vinTextView.setText(userVehicleVO.getVin());
        colorTextView.setText(userVehicleVO.getColor());
        locationTextView.setText(userVehicleVO.getLocation());
        mileageTextView.setText(userVehicleVO.getMileage());
        activeDtcCountTextView.setText(Integer.toString(userVehicleVO.getActiveDtcCount()));

    }
}
