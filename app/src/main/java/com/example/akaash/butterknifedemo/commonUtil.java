package com.example.akaash.butterknifedemo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;

import butterknife.BindView;

/**
 * Created by akaash on 9/1/18.
 */

public class commonUtil {

    @BindView(R.id.relativeLayout)
    RelativeLayout rvParentView;

    public static String getFontName(int index) {
        return "Regular.ttf";
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
