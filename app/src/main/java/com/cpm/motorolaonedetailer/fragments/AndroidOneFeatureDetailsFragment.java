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


public class AndroidOneFeatureDetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_android_one_feature_details, container, false);
        decalaration(view);
        return view;
    }

    private void decalaration(View view) {
        ImageView smart_btn = view.findViewById(R.id.smart_btn);
        ImageView amazing_btn = view.findViewById(R.id.amazing_btn);
        ImageView secure_btn = view.findViewById(R.id.secure_btn);

        smart_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 loadFragment(new OSSmartFeatureFragment());
             }
         }
        );

        amazing_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 loadFragment(new OSAmazingFeatureFragment());
             }
         }
        );

        secure_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 loadFragment(new OSSecureFeatureFragment());
             }
         }
        );
    }


    private void loadFragment(Fragment fragment) {
        //   backStateName = fragment.getClass().getName();
        FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null); // adding fragment to back stack
        fragmentTransaction.commit(); // save the changes
    }
}
