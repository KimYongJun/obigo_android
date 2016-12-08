package com.obigo.obigoproject.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.obigo.obigoproject.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by O BI HE ROCK on 2016-11-28
 * 김용준, 최현욱
 * login_page
 * login 작업 수행 - registration_id, user_id , password를 보냄
 * API : /api/login
 * Bundle check 작업 수행 - android_bundle_version
 * API : /api/bundlecheck
 * Bundle update 작업 수행 - 송신 데이터 없음
 * API : /api/bundleupdate
 */

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.user_id)
    EditText _idText;
    @Bind(R.id.user_password)
    EditText _passwordText;
    @Bind(R.id.btn_login)
    Button _loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
    }

    // 로그인 버튼 클릭
    @OnClick(R.id.btn_login)
    public void login() {

        // 로그인 정규식 체크
//        if (!validate()) {
//            onLoginFailed();
//            return;
//        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Logging in to your account...");
        progressDialog.show();

        String userId = _idText.getText().toString();
        String userPassword = _passwordText.getText().toString();

        /**
         * 로그인 인증을 위한 로직, Server로 데이터를 보냄
         * 여기서 Bundle check, update / registration_id를 등록함
         */
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 2000);
    }

    // 뒤로가기
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    // 로그인 성공
    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
        startActivity(new Intent(getApplication(), CarListActivity.class));
    }

    // 로그인 실패
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    // 로그인 정규식 체크
    public boolean validate() {
        boolean valid = true;

        String id = _idText.getText().toString();
        String password = _passwordText.getText().toString();

        if (id.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(id).matches()) {
            _idText.setError("enter a valid id address");
            valid = false;
        } else {
            _idText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}