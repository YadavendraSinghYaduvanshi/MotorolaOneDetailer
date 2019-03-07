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


public class SmartCameraVideoFragment extends Fragment {

    private VideoView videoView;
    private boolean flag = false;
    private ImageView next_btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_smart_camera_video, container, false);
        decalaration(view);
        return view;
    }

    private void decalaration(View view) {
        videoView =
                view.findViewById(R.id.video_view);
        next_btn = view.findViewById(R.id.next_btn);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                next_btn.setVisibility(View.VISIBLE);
                flag = true;
            }
        });

        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(flag && !videoView.isPlaying()){
                    flag = false;
                    CommonFunctions.setVideoSize(getActivity(), videoView, R.raw.smart_camear_video);
                    next_btn.setVisibility(View.GONE);
                }
                return true;
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = false;
                next_btn.setVisibility(View.GONE);
                loadFragment(new SmartCameraFunctionFargment());
            }
        });

        CommonFunctions.setVideoSize(getActivity(),videoView, R.raw.smart_camear_video);
    }

    private void loadFragment(SmartCameraFunctionFargment fragment) {
        //   backStateName = fragment.getClass().getName();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}
