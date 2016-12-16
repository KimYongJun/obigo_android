package com.obigo.obigoproject.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.obigo.obigoproject.R;
import com.obigo.obigoproject.presenter.UserVehiclePresenter;
import com.obigo.obigoproject.util.ConstantsUtil;
import com.obigo.obigoproject.util.FlipperUtil;
import com.obigo.obigoproject.vo.UserVehicleVO;
import com.viewpagerindicator.PageIndicator;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by O BI HE ROCK on 2016-11-28
 * 김용준, 최현욱
 * 차량 리스트를 보여주는 페이지 - user_id
 * API : /api/uservehicle
 * model_name, model_image, vin
 */

public class CarListActivity extends MenuActivity {

    @Bind(R.id.car_list_view)
    ViewPager viewPager;
    @Bind(R.id.indicator)
    PageIndicator indicator;
    // 차량 현재 이미지
    @Bind(R.id.current_icon_image)
    ImageView currentCarListImage;
    // 차량 다음 이미지
    @Bind(R.id.next_icon_image)
    ImageView nextCarListImage;
    // 소유 차량 갯수
    private int carListSize;
    private int lastPage = 0;
    // 이미지 배열(추후 스트링으로 바꿀예정)
    private int[] icons;
    // 차량 이름 리스트
    private String[] carNameList;

    // 16-12-13 추가
    private UserVehiclePresenter userVehiclePresenter;
    private List<UserVehicleVO> userVehicleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_list);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setTitle("CAR LIST");
        ButterKnife.bind(this);

        userVehiclePresenter = new UserVehiclePresenter(this, "ssung");
        userVehiclePresenter.getUserVehicleList();

        initAdapter();
    }

    private void initAdapter() {
        // image change
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (lastPage != viewPager.getCurrentItem()) {
                    lastPage = viewPager.getCurrentItem();

                    final ImageView fadeoutImage;
                    final ImageView fadeinImage;
                    if (currentCarListImage.getVisibility() == View.VISIBLE) {
                        fadeoutImage = currentCarListImage;
                        fadeinImage = nextCarListImage;

                    } else {
                        fadeoutImage = nextCarListImage;
                        fadeinImage = currentCarListImage;
                    }

                    fadeinImage.bringToFront();
                    fadeinImage.setImageResource(icons[lastPage]);
                    fadeinImage.clearAnimation();
                    fadeoutImage.clearAnimation();

                    Animation outAnimation = AnimationUtils.loadAnimation(CarListActivity.this, R.anim.icon_anim_fade_out);
                    outAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            fadeoutImage.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    Animation inAnimation = AnimationUtils.loadAnimation(CarListActivity.this, R.anim.icon_anim_fade_in);
                    inAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            fadeinImage.setVisibility(View.VISIBLE);
                        }

                        // 사용하지 않는 메소드
                        @Override
                        public void onAnimationEnd(Animation animation) {
                        }

                        // 사용하지 않는 메소드
                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });

                    fadeoutImage.startAnimation(outAnimation);
                    fadeinImage.startAnimation(inAnimation);
                }
            }


            // 사용하지 않는 메소드
            @Override
            public void onPageSelected(int position) {

            }

            // 사용하지 않는 메소드
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void dispatchUserVehicleInfo(List<UserVehicleVO> userVehicleList) {
        this.userVehicleList = userVehicleList;
        initVariable();
        System.out.println(userVehicleList.toString());
    }

    private void initVariable() {
        // 이미지 파일 리스트 넣기
        icons = new int[]{
                R.drawable.car_list_file3,
                R.drawable.car_list_file4,
                R.drawable.car_list_file2,
                R.drawable.car_list_file1
        };

        // 차량 갯수 대입
        carListSize = userVehicleList.size();

        // 차량 이름 리스트 넣기
        carNameList = new String[userVehicleList.size()];

        for (int i = 0; i < userVehicleList.size(); i++) {
            carNameList[i] = userVehicleList.get(i).getModelName();
        }

        if(userVehicleList.size() > 0) {
            System.out.println(ConstantsUtil.SERVER_API_URL_REAL + ConstantsUtil.SERVER_VEHICLE_IMAGE_URL + userVehicleList.get(0).getModelImage());

            // 처음 이미지 고정 데이터 넣기
            Glide.with(this).load(ConstantsUtil.SERVER_API_URL_REAL + ConstantsUtil.SERVER_VEHICLE_IMAGE_URL + userVehicleList.get(0).getModelImage()).into(currentCarListImage);
        }

        nextCarListImage.setVisibility(View.GONE);
        viewPager.setAdapter(new IntroAdapter());
        viewPager.setPageMargin(0);
        viewPager.setOffscreenPageLimit(1);
        indicator.setViewPager(viewPager);
    }


    private class IntroAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return carListSize;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        // 차량 이미지 마다 이름 넣기
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = View.inflate(container.getContext(), R.layout.car_list_name, null);
            TextView messageTextView = ButterKnife.findById(view, R.id.message_text);

            messageTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CarListActivity.this, CarDetailActivity.class);
                    intent.putExtra("carDetailInfo", userVehicleList.get(position));
                    startActivity(intent);
                }
            });

            container.addView(view, 0);
            messageTextView.setText(FlipperUtil.replaceTags(carNameList[position], getApplicationContext()));
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
