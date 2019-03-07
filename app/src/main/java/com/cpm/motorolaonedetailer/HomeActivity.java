package com.cpm.motorolaonedetailer;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.cpm.motorolaonedetailer.Constant.CommonFunctions;
import com.cpm.motorolaonedetailer.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CommonFunctions.setScreenFullView(HomeActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       loadFragment();
    }


    private void loadFragment() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        HomeFragment fragment = new HomeFragment();

        fragmentTransaction.add(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
