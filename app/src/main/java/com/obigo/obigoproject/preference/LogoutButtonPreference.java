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
 * logout button
 *
 * onCreateView()는 Fragment에 실제 사용할 뷰를 만드는 작업을 하는 메소드이다.
 * LayoutInflater를 인자로 받아서 layout으로 설정한 XML을 연결하거나
 * bundle에 의한 작업을 하는 메소드이다.
 *
 */

public class LogoutButtonPreference extends android.preference.Preference {
    private Context mContext;
    @Bind(R.id.logoutBtn) Button mButtonLogout;

    // constructor
    public LogoutButtonPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    public LogoutButtonPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LogoutButtonPreference(Context context) {
        this(context, null);
    }

    @Override
    protected View onCreateView(android.view.ViewGroup parent) {
        final LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View layout = layoutInflater.inflate(R.layout.preference_button_logout, parent, false);
        ButterKnife.bind(this, layout);

        return layout;
    }

    // 로그아웃 버튼 클릭
    @OnClick(R.id.logoutBtn)
    public void logout() {
        Toast.makeText(mContext, "you click Logout", Toast.LENGTH_SHORT).show();
    }



}
