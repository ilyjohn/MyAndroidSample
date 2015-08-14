package com.example.panlin_pan.myapplication.scenario_rotate;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.panlin_pan.myapplication.R;

/**
 * Created by panlin_pan on 8/10/2015.
 */
public class MyPortraitFrag extends Fragment {
    public MyPortraitFrag() {
    }

    public String getWhich() {
        return Which;
    }

    public void setWhich(String which) {
        Which = which;
    }

    String Which;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        String which = getWhich();
        Bundle b = getArguments();
        which = b.getString("which");
        if(savedInstanceState == null){
            return inflater.inflate(R.layout.my_portrait_frag2, container, false);

        }else {
            which = savedInstanceState.getString("which");
            if (which == "2")
                return inflater.inflate(R.layout.my_portrait_frag2, container, false);
            else
                return inflater.inflate(R.layout.my_portrait_frag, container, false);
        }
    }

}
