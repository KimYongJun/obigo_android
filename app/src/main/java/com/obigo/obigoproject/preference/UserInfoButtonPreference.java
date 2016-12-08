package com.obigo.obigoproject.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.obigo.obigoproject.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by O BI HE ROCK on 2016-12-06
 * 김용준, 최현욱
 * user_info button
 *
 * onCreateView()는 Fragment에 실제 사용할 뷰를 만드는 작업을 하는 메소드이다.
 * LayoutInflater를 인자로 받아서 layout으로 설정한 XML을 연결하거나
 * bundle에 의한 작업을 하는 메소드이다.
 *
 */

public class UserInfoButtonPreference extends android.preference.Preference {
    private Context mContext;
    @Bind(R.id.userInfoBtn) Button mButtonUserInfo;

    // constructor
    public UserInfoButtonPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    public UserInfoButtonPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UserInfoButtonPreference(Context context) {
        this(context, null);
    }

    @Override
    protected View onCreateView(android.view.ViewGroup parent) {
        final LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View layout = layoutInflater.inflate(R.layout.preference_button_userinfo, parent, false);
        ButterKnife.bind(this, layout);

        return layout;
    }

    // 사용자 정보 조회 클릭
    @OnClick(R.id.userInfoBtn)
    public void showUserInfo() {
        Toast.makeText(mContext, "you click UserInfo", Toast.LENGTH_SHORT).show();
    }
}
