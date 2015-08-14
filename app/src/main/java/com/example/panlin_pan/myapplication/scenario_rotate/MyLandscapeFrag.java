package com.example.panlin_pan.myapplication.scenario_rotate;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.panlin_pan.myapplication.R;

/**
 * Created by panlin_pan on 8/10/2015.
 */
public class MyLandscapeFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        View view =  inflater.inflate(R.layout.my_landscape_frag,container,false);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        view.setLayoutParams(params);
        return view;
    }
}
