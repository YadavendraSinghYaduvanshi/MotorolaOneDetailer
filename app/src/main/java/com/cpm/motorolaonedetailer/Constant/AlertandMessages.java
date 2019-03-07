package com.cpm.motorolaonedetailer.Constant;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;


/**
 * Created by neeraj on 10/27/2018.
 */

@SuppressWarnings("deprecation")
class AlertandMessages {

    public AlertandMessages(Activity activity, String data, String condition, Exception exception) {
        Activity activity1 = activity;
        String data1 = data;
        String condition1 = condition;
    }

    public static void showSnackbarMsg(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    public static void showSnackbarMsg(Context context, String message) {
        Snackbar.make(((Activity) context).getCurrentFocus(), message, Snackbar.LENGTH_SHORT).show();
    }


    public static void showToastMsg(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
