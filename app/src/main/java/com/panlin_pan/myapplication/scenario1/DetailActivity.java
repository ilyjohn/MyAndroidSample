package com.panlin_pan.myapplication.scenario1;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.panlin_pan.myapplication.R;

/**
 * Created by panlin_pan on 8/12/2015.
 */
public class DetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // If the screen is now in landscape mode, we can show the
            // dialog in-line with the list so we don't need this activity.
            finish();
            return;
        }

        if (savedInstanceState == null) {
            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, detailsFragment).commit();
        }
    }
}
