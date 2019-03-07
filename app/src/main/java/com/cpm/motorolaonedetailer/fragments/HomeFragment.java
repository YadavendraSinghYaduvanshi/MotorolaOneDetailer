package com.cpm.motorolaonedetailer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cpm.motorolaonedetailer.GetterSetter.VisitCountGetterSetter;
import com.cpm.motorolaonedetailer.R;
import com.cpm.motorolaonedetailer.database.MotorolaDetailerDB;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private MotorolaDetailerDB db;
    int smartCameraSystemCounter = 0;
    private int superFastProcessorCounter=0;
    private int notchDisplayProcessorCounter=0;
    private int turboPowerChargingCounter=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_home, container, false);
        declaration(view);
        return view;
    }

    private void declaration(View view) {
        ImageView smartCameraImg = view.findViewById(R.id.smart_camera_system);
        ImageView superFastProcessorImg = view.findViewById(R.id.super_fast_processor);
        ImageView notchDisplayProcessorImg = view.findViewById(R.id.u_notch_display_processor);
        ImageView turboPowerChargingImg = view.findViewById(R.id.turbo_power_charging);

        smartCameraImg.setOnClickListener(this);
        superFastProcessorImg.setOnClickListener(this);
        notchDisplayProcessorImg.setOnClickListener(this);
        turboPowerChargingImg.setOnClickListener(this);

        // creating new object of the Database
        db = new MotorolaDetailerDB(getActivity());
    }

    @Override
    public void onClick(View view) {

        int count = 0;
        boolean val;
        String emp_id = "";
        String visit_date = "";
        switch (view.getId()){

            case R.id.super_fast_processor:
                // do your code
                db.open();
                VisitCountGetterSetter visitCountObj = db.getInsertedVisitCountData(emp_id, visit_date);
                if(visitCountObj.getSuper_fast_processor_count() != 0){
                    count = visitCountObj.getSuper_fast_processor_count();
                    count = count + 1 ;
                    val = db.updateVisitCountData(visit_date, emp_id,1, count);
                }else{
                    superFastProcessorCounter++;
                    val = db.insertVisitCountData(visit_date,superFastProcessorCounter,1, emp_id);
                }
                if(val){
                    loadFragment(new SmartProcessorFragment(), true,"processor");
                }
                break;


            case R.id.u_notch_display_processor:
                // do your code
                db.open();
                visitCountObj = db.getInsertedVisitCountData(emp_id, visit_date);
                if(visitCountObj.getU_notch_display_count() != 0){
                    count = visitCountObj.getU_notch_display_count();
                    count = count + 1 ;
                    val = db.updateVisitCountData(visit_date, emp_id,2, count);
                }else{
                    notchDisplayProcessorCounter++;
                    val = db.insertVisitCountData(visit_date,notchDisplayProcessorCounter,2, emp_id);
                }
                if(val){
                    loadFragment(new UNotchDesignDisplayVideoFragment(), true ,"notch_display");
                }

                break;


            case R.id.smart_camera_system:
                // do your code
//                db.open();
//                visitCountObj = db.getInsertedVisitCountData(emp_id,visit_date);
//                if(visitCountObj.getSmart_camera_count() != 0){
//                    count  = visitCountObj.getSmart_camera_count();
//                    count = count + 1 ;
//                    val = db.updateVisitCountData(visit_date,emp_id,3,count);
//                }else{
//                    smartCameraSystemCounter++ ;
//                    val = db.insertVisitCountData(visit_date,smartCameraSystemCounter,3,emp_id);
//                }
//                if(val){
                    loadFragment(new SmartCameraVideoFragment(),true,"camera_system");
                //}
                break;


            case R.id.turbo_power_charging:
                // do your code
                db.open();
                visitCountObj = db.getInsertedVisitCountData(emp_id, visit_date);
                if(visitCountObj.getTurbo_power_charging_count() != 0){
                    count = visitCountObj.getTurbo_power_charging_count();
                    count = count + 1 ;
                    val = db.updateVisitCountData(visit_date, emp_id,4, count);
                }else{
                    turboPowerChargingCounter++;
                    val = db.insertVisitCountData(visit_date,turboPowerChargingCounter,4, emp_id);
                }
                if(val){
                    loadFragment(new TurboPowerChargingVideoFragment(), true,"charging");
                }

                break;

            default:
                break;
        }
    }

    private void loadFragment(Fragment fragment, boolean flag, String backStateName) {
     //   backStateName = fragment.getClass().getName();
        FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        if(flag){
            fragmentTransaction.addToBackStack(backStateName); // adding fragment to back stack
        }
        fragmentTransaction.commit(); // save the changes
    }
}
