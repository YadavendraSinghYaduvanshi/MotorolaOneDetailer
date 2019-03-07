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


public class GoogleLensImageFragment extends Fragment implements View.OnClickListener{

    private ImageView btnLeftImg;
    private ImageView btnRightImg;
    private ImageView img_view;
    private RelativeLayout relative_layout_view;
    private final int set1=1;
    private final int set2=2;
    private final int set3=3;
    private int currentset;
    private int normalImg;
    private int backgroundImg;
    private int leftMode;
    private int rightMode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_google_lens_image, container, false);
        decalartion(view);
        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        return view;
    }

    private void decalartion(View view) {
        btnLeftImg = view.findViewById(R.id.left_btn);
        btnRightImg = view.findViewById(R.id.right_btn);
        img_view = view.findViewById(R.id.img);
        relative_layout_view = view.findViewById(R.id.relative_layout_set1);

        btnLeftImg.setOnClickListener(this);
        btnRightImg.setOnClickListener(this);
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

        }
    }

    private void selectSets(int set){
        switch (set){
            case set1:
                setCurrentMode(set1,R.drawable.identify_plants_and_animals_background,R.drawable.identify_plants_and_animals_img,0,set2,false,true);
                break;

            case set2:
                setCurrentMode(set2,R.drawable.learn_about_landmarks_background,R.drawable.learn_about_landmarks_img,set1,set3,true,true);
                break;

            case set3:
                setCurrentMode(set3,R.drawable.object_recognition_background,R.drawable.object_recognition_img,set2,0,true,false);
                break;

        }
    }


    private void setCurrentMode(int currentset,int backgroundImg,int img, int leftMode,int rightMode,boolean leftImgVisible,boolean rightImgVisible){
        this.currentset = currentset;
        this.normalImg = img;
        this.backgroundImg = backgroundImg;
        this.leftMode = leftMode;
        this.rightMode = rightMode;

        relative_layout_view.setBackgroundResource(backgroundImg);
        img_view.setImageResource(img);

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
