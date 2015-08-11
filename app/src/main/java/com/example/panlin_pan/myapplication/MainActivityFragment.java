package com.example.panlin_pan.myapplication;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*View content = getActivity().findViewById(R.id.myContent);
        if (content!=null&& content.getVisibility()==View.VISIBLE){
            Button btnWifi = (Button)getActivity().findViewById(R.id.btnWifi);
            if(btnWifi!=null) {
                btnWifi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentFragment cf = new ContentFragment();

                        Bundle b = new Bundle();
                        b.putString("act", "wifi");
                        cf.setArguments(b);
                        android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.myContent, cf);
                        ft.commit();
                    }
                });
            }

        }*/
    }
}
