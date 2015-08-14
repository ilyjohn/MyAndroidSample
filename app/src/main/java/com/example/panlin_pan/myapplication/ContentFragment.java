package com.example.panlin_pan.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.panlin_pan.myapplication.singleactivity.WifiActivity;

/**
 * Created by panlin_pan on 8/7/2015.
 */
public class ContentFragment extends Fragment {
    public ContentFragment(){

    }
    protected Activity ContentActivity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String actName = this.getArguments().getString("act");
        if (actName == "wifi"){
            ContentActivity = new WifiActivity();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
