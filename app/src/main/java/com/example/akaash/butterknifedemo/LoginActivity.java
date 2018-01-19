package com.example.akaash.butterknifedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.relativeLayout)
    RelativeLayout rlParenView;

    @BindView(R.id.helloText)
    TextView tvHelloText;

    @BindView(R.id.pressMe)
    Button btnPressMe;

    @BindView(R.id.passwordEditText)
    EditText etPassword;

    @BindView(R.id.usernameEditText)
    EditText etUserName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        App.getPreference().setString(AppConstant.USERNAME, "akaash@coditas.com");
        App.getPreference().setString(AppConstant.PASSWORD, "1234");
    }

    @OnClick(R.id.pressMe)
    public void onClickClickMe(View view) {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        commonUtil.hideKeyboardFrom(this,view);
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            SnackBarUtils.showSnackBar(rlParenView, "User name or password is empty");
        } else {
            if (userName.equals(App.getPreference().getString(AppConstant.USERNAME))) {
                if (password.equals(App.getPreference().getString(AppConstant.PASSWORD))) {

                    App.getPreference().setUserLogged(true);
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                } else {
                    SnackBarUtils.showSnackBar(rlParenView, "Wrong password");
                }
            } else {
                SnackBarUtils.showSnackBar(rlParenView, "Wrong user name");
            }
        }
    }
}
