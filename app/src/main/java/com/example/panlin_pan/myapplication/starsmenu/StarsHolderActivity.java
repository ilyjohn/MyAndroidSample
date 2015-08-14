package com.example.panlin_pan.myapplication.starsmenu;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.panlin_pan.myapplication.R;

import java.util.ArrayList;

public class StarsHolderActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stars_holder);

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            arrayList.add(i);
        }

        ListView lv =(ListView) findViewById(R.id.listView);
        ArrayAdapter<Integer> array2ListView =new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_activated_1,arrayList);
        lv.setAdapter(array2ListView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stars_holder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
