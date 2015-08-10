package com.example.panlin_pan.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;


public class MyRotateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_rotate);

        FragmentManager fragmentManager =  getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

        Configuration configuration= getResources().getConfiguration();

        if (configuration.orientation== Configuration.ORIENTATION_LANDSCAPE){
            MyLandscapeFrag landscapeFrag = new MyLandscapeFrag();
            fragmentTransaction.replace(android.R.id.content,landscapeFrag);

            MyLandscapeFrag2 landscape2 =  MyLandscapeFrag2.newInstance("l2");
            fragmentTransaction.add(android.R.id.content,landscape2);
        }else
        {
            Bundle b = new Bundle();
            b.putString("which","2");
            MyPortraitFrag portrait = new MyPortraitFrag();
            portrait.setWhich("2");
            portrait.setArguments(b);
            fragmentTransaction.replace(android.R.id.content,portrait);
        }

        fragmentTransaction.commit();

    }


}
