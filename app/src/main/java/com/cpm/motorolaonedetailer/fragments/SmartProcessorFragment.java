package com.cpm.motorolaonedetailer.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.cpm.motorolaonedetailer.Constant.CommonFunctions;
import com.cpm.motorolaonedetailer.R;

public class SmartProcessorFragment extends Fragment{

    private VideoView videoView;
    private boolean flag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_smart_processor_screen, container, false);
        decalration(view);
        return view;
    }

    private void decalration(View view) {
        videoView =
                view.findViewById(R.id.video_view);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                flag = true;
            }
        });

        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(flag && !videoView.isPlaying()){
                    flag = false;
                    CommonFunctions.setVideoSize(getActivity(),videoView, R.raw.smart_processor_video);
                }
                return true;
            }
        });

        CommonFunctions.setVideoSize(getActivity(),videoView, R.raw.smart_processor_video);

        ImageView processor_img = view.findViewById(R.id.processor_img);
        ImageView android_feature_img = view.findViewById(R.id.os_img);

        processor_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new ProcessorVideoFragment());
            }
        });

        android_feature_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AndroidOneFeatureDetailsFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        //   backStateName = fragment.getClass().getName();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}
