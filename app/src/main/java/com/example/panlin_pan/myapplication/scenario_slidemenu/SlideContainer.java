package com.example.panlin_pan.myapplication.scenario_slidemenu;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.panlin_pan.myapplication.R;

/**
 * Created by panlin_pan on 8/13/2015.
 */
public class SlideContainer extends Activity {
    MyHorizontalScrollView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.slidding_container);

        Button btn1 = (Button) findViewById(R.id.id_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopFragment("buletooth");
            }
        });

        Button btn2 = (Button) findViewById(R.id.id_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopFragment("wifi");
            }
        });

        Button btn3 = (Button) findViewById(R.id.id_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopFragment("dragdrop");
            }
        });

        Button btn4 = (Button) findViewById(R.id.id_btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopFragment("rotate");
            }
        });

        Button btn5 = (Button) findViewById(R.id.id_btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopFragment("mystudent");
            }
        });

        Button btn6 = (Button) findViewById(R.id.id_btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopFragment("masterdetail");
            }
        });

        menu = (MyHorizontalScrollView) findViewById(R.id.horizontalScrollView);

        Button btnSwitchMenu = (Button) findViewById(R.id.btnSwitchMenu);
        btnSwitchMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
            }
        });
    }

    private void PopFragment(String activity) {
        MyFragment myFragment = MyFragment.newInstance(activity);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.containerFrame, myFragment);

        fragmentTransaction.commit();
    }

}
