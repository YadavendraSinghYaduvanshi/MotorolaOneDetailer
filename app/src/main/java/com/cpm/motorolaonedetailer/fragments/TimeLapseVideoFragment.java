package com.cpm.motorolaonedetailer.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.cpm.motorolaonedetailer.Constant.CommonFunctions;
import com.cpm.motorolaonedetailer.R;

public class TimeLapseVideoFragment extends Fragment {

    private VideoView videoView;
    private boolean flag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_time_lapse_video, container, false);
        decalartion(view);
        return view;
    }


    private void decalartion(View view) {
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
                    CommonFunctions.setVideoSize(getActivity(),videoView, R.raw.time_lapse_video);
                }
                return true;
            }
        });

        CommonFunctions.setVideoSize(getActivity(),videoView, R.raw.time_lapse_video);
    }
}
