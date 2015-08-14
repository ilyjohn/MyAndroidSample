package com.example.panlin_pan.myapplication.singleactivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.util.ArrayList;
import android.content.Intent;

import com.example.panlin_pan.myapplication.R;

public class PlayerActivity extends ActionBarActivity {
MediaPlayer mp;
    ArrayList<File> songs;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Intent  i = getIntent();
        Bundle b = i.getExtras();
        songs =(ArrayList) b.getParcelableArrayList("songs");
        position = b.getInt("pos",0);

        Uri u = Uri.parse(songs.get(position).toString());
        mp = MediaPlayer.create(getApplicationContext(),u);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
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
