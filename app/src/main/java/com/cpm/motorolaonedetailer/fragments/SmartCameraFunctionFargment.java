package com.cpm.motorolaonedetailer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cpm.motorolaonedetailer.R;

public class SmartCameraFunctionFargment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_smart_camera_function, container, false);
        decalration(view);
        return view;
    }



    private void decalration(View view) {
        ImageView google_lens_img = view.findViewById(R.id.google_lens);
        ImageView portrait_mode_img = view.findViewById(R.id.portrait_mode);
        ImageView spot_color_img = view.findViewById(R.id.spot_color);
        ImageView time_lapse_img = view.findViewById(R.id.time_lapse);

        portrait_mode_img.setOnClickListener(this);
        spot_color_img.setOnClickListener(this);
        google_lens_img.setOnClickListener(this);
        time_lapse_img.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.google_lens:
                // do your code
                loadFragment(new GoogleLensImageFragment());
                break;

            case R.id.portrait_mode:
                // do your code
                loadFragment(new PortraitImageFragment());
                break;


            case R.id.spot_color:
                // do your code
                    loadFragment(new SpotColorImageFragment());
                break;

            case R.id.time_lapse:
                // do your code
                loadFragment(new TimeLapseVideoFragment());
                break;

        }
    }

    private void loadFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager fm = getActivity().getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null); // adding fragment to back stack
        fragmentTransaction.commit(); // save the changes
    }
}
