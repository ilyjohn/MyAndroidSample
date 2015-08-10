package com.example.panlin_pan.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by panlin_pan on 8/10/2015.
 */
public class MyLandscapeFrag2 extends Fragment {
    public static MyLandscapeFrag2 newInstance(String id){
        MyLandscapeFrag2 myLandscapeFrag2 = new MyLandscapeFrag2();
        Bundle b = new Bundle();
        b.putString("flag",id);
        myLandscapeFrag2.setArguments(b);
        return myLandscapeFrag2;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        Bundle b = getArguments();
        String flag= b.getString("flag");
        return  inflater.inflate(R.layout.my_landscape_frag2,container,false);
    }
}
