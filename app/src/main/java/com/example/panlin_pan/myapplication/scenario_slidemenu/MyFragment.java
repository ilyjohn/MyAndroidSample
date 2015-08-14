package com.example.panlin_pan.myapplication.scenario_slidemenu;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.panlin_pan.myapplication.scenario_rotate.MyRotateActivity;
import com.example.panlin_pan.myapplication.R;
import com.example.panlin_pan.myapplication.scenario_master_details.FragmentLayout;
import com.example.panlin_pan.myapplication.singleactivity.BluetoothActivity;
import com.example.panlin_pan.myapplication.singleactivity.DragDropActivity;
import com.example.panlin_pan.myapplication.singleactivity.StudentActivity;
import com.example.panlin_pan.myapplication.singleactivity.WifiActivity;

/**
 * Created by panlin_pan on 8/14/2015.
 */
public class MyFragment extends Fragment {
    public static MyFragment newInstance(String viewName) {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("viewName", viewName);

        myFragment.setArguments(bundle);

        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String viewName = "";
        Activity activity = null;
        if (bundle != null) {
            viewName = bundle.getString("viewName");
        }
        switch (viewName) {
            case "bluetooth":
                activity = new BluetoothActivity();
                return inflater.inflate(R.layout.activity_bluetooth,container,false);
            case "wifi":
                activity = new WifiActivity();
                return inflater.inflate(R.layout.activity_wifi,container,false);
            case "dragdrop":
                activity = new DragDropActivity();
                return inflater.inflate(R.layout.activity_drag_drop,container,false);
            case "rotate":
                activity = new MyRotateActivity();
                return inflater.inflate(R.layout.activity_my_rotate,container,false);
            case "mystudent":
                activity = new StudentActivity();
                return inflater.inflate(R.layout.activity_student,container,false);
            case "masterdetail":
                activity = new FragmentLayout();
                return inflater.inflate(R.layout.activity_fragment_layout,container,false);
            default:
                activity = new BluetoothActivity();
                return inflater.inflate(R.layout.activity_bluetooth,container,false);
        }


        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
