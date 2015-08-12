package com.panlin_pan.myapplication.scenario1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * Created by panlin_pan on 8/12/2015.
 */
public class DetailsFragment extends Fragment {
    public static DetailsFragment newInstance(int index){
        DetailsFragment detailsFragment=new DetailsFragment();
        Bundle bundle =new Bundle();
        bundle.putInt("index",index);
        detailsFragment.setArguments(bundle);

        return detailsFragment;
    }

    public int getShowIndex(){
       return getArguments().getInt("index",0);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        ScrollView scroller = new ScrollView(getActivity());
        TextView textView=new TextView(getActivity());

        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4,getActivity().getResources().getDisplayMetrics());

        textView.setPadding(padding,padding,padding,padding);
        scroller.addView(textView);
        scroller.setMinimumHeight(200);
        textView.setText(SuperHeroInfo.HISTORY[getShowIndex()]);

        return scroller;
    }
}
