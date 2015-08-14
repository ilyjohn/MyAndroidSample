package com.example.panlin_pan.myapplication.scenario_master_details;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.panlin_pan.myapplication.R;

/**
 * Created by panlin_pan on 8/12/2015.
 */
public class TitlesFragment extends ListFragment {
    int curCheckPosition = 0;
    Boolean duelPane = false;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> connectArrayToListView = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_activated_1
                , SuperHeroInfo.NAMES
        );

        setListAdapter(connectArrayToListView);

        View detaiFrame = getActivity().findViewById(R.id.details);
        duelPane = detaiFrame != null && detaiFrame.getVisibility() == View.VISIBLE;
        if (savedInstanceState!=null){
            curCheckPosition = savedInstanceState.getInt("curChoice",0);
        }

        if (duelPane){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            ShowDetail(curCheckPosition);
        }

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
        ShowDetail(position);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", curCheckPosition);
    }

    void ShowDetail(int position) {
        curCheckPosition = position;
        if (duelPane) {
            getListView().setItemChecked(position, true);

            DetailsFragment detailsFragment = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
            if (detailsFragment == null || detailsFragment.getShowIndex() != position) {
                detailsFragment = DetailsFragment.newInstance(position);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.details, detailsFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }

        } else {
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("index", position);
            startActivity(intent);

        }

    }
}
