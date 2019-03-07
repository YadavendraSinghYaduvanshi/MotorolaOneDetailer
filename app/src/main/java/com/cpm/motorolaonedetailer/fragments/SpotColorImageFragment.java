package com.cpm.motorolaonedetailer.fragments;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cpm.motorolaonedetailer.R;


public class SpotColorImageFragment extends Fragment implements View.OnClickListener{

    private ImageView btnLeftImg;
    private ImageView btnRightImg;
    private ImageView btnNormalImg;
    private ImageView btnHighResolutionImg;
    private RelativeLayout relative_layout_view;
    private final int set1=1;
    private final int set2=2;
    private int normalImg;
    private int highResolutionImg;
    private int leftMode;
    private int rightMode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_spot_color_image, container, false);
        decalartion(view);
        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        return view;
    }

    private void decalartion(View view) {
        btnLeftImg = view.findViewById(R.id.left_btn);
        btnRightImg = view.findViewById(R.id.right_btn);
        btnNormalImg = view.findViewById(R.id.btn_normal);
        btnHighResolutionImg = view.findViewById(R.id.btn_high_resolution);
        relative_layout_view = view.findViewById(R.id.relative_layout_set1);

        btnLeftImg.setOnClickListener(this);
        btnRightImg.setOnClickListener(this);
        btnNormalImg.setOnClickListener(this);
        btnHighResolutionImg.setOnClickListener(this);
        selectSets(set1);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.left_btn:
                // do your code
                selectSets(leftMode);
                break;

            case R.id.right_btn:
                // do your code
                selectSets(rightMode);
                break;

            case R.id.btn_normal:
                // do your code
                btnHighResolutionImg.setImageResource(R.drawable.btn_spot_color_white);
                btnNormalImg.setImageResource(R.drawable.btn_normal_green);
                relative_layout_view.setBackgroundResource(normalImg);
                break;

            case R.id.btn_high_resolution:
                // do your code
                btnHighResolutionImg.setImageResource(R.drawable.btn_spot_color_green);
                btnNormalImg.setImageResource(R.drawable.btn_normal_white);
                relative_layout_view.setBackgroundResource(highResolutionImg);

                break;
        }
    }

    private void selectSets(int set){
        switch (set){
            case 1:
                setCurrentMode(set1,R.drawable.rear_normal_spot_color_img_set1,R.drawable.rear_spot_color_img_set1,0,2,false,true);
                break;

            case 2:
                setCurrentMode(set2,R.drawable.rear_normal_spot_color_img_set2,R.drawable.rear_spot_color_img_set2,1,0,true,false);
                break;

        }
    }


    private void setCurrentMode(int currentset,int normalImg,int highResolutionImg, int leftMode,int rightMode,boolean leftImgVisible,boolean rightImgVisible){
        int currentset1 = currentset;
        this.normalImg = normalImg;
        this.highResolutionImg = highResolutionImg;
        this.leftMode = leftMode;
        this.rightMode = rightMode;

        btnHighResolutionImg.setImageResource(R.drawable.btn_spot_color_white);
        btnNormalImg.setImageResource(R.drawable.btn_normal_green);
        relative_layout_view.setBackgroundResource(normalImg);

        if(leftImgVisible) {
            btnLeftImg.setVisibility(View.VISIBLE);
        }else{
            btnLeftImg.setVisibility(View.INVISIBLE);
        }

        if(rightImgVisible) {
            btnRightImg.setVisibility(View.VISIBLE);
        }else{
            btnRightImg.setVisibility(View.INVISIBLE);
        }

    }
}
