package com.example.akaash.butterknifedemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by akaash on 9/1/18.
 */

public class LauncherActivity extends AppCompatActivity {

    private AppCompatActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        mActivity = this;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (!App.getPreference().isUserLogged()) {
                    intent = new Intent(mActivity, LoginActivity.class);
                } else {
                    intent = new Intent(mActivity, DashboardActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, AppConstant.splashTime);


    }
}
