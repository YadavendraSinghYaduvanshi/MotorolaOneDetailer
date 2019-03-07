package com.cpm.motorolaonedetailer.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.cpm.motorolaonedetailer.Constant.CommonFunctions;
import com.cpm.motorolaonedetailer.R;


public class ProcessorVideoFragment extends Fragment {

    private VideoView videoView;
    private ImageView next_btn;
    private ImageView sd_btn;
    private int playVideo = 1;
    private boolean flag = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_processor_video, container, false);
        decalartion(view);
        return view;
    }


    private void decalartion(final View view) {
        videoView =
                view.findViewById(R.id.video_view);

        next_btn = view.findViewById(R.id.media_tek);
        sd_btn = view.findViewById(R.id.sd_btn);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if(playVideo == 1) {
                    flag = true;
                }else{
                    flag = playVideo == 2;
                }
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo=1;
                flag = false;
                next_btn.setVisibility(View.GONE);
                sd_btn.setVisibility(View.VISIBLE);
                CommonFunctions.setVideoSize(getActivity(),videoView, R.raw.pubg_video_mediatek);
            }
        });

        sd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo=2;
                flag = false;
                next_btn.setVisibility(View.VISIBLE);
                sd_btn.setVisibility(View.GONE);
                CommonFunctions.setVideoSize(getActivity(),videoView, R.raw.pubg_video_hd);
            }
        });

        CommonFunctions.setVideoSize(getActivity(),videoView, R.raw.pubg_video_hd);
    }
}
