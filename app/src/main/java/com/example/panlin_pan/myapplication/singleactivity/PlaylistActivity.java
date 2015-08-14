package com.example.panlin_pan.myapplication.singleactivity;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import android.util.Log;

import com.example.panlin_pan.myapplication.R;

public class PlaylistActivity extends ActionBarActivity {
    ListView lv;
    ArrayList<File> songs;
    String[] items;
    String msg ="PlayList: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        lv=(ListView)findViewById(R.id.lv_activity_playlist);
        Log.d(msg, " findViewById. ");
        songs = findFiles(Environment.getExternalStorageDirectory());
        items = new String[songs.size()];
        for(int i=0;i<songs.size();i++){
            items[i]=songs.get(i).getName();
        }

        ArrayAdapter<String> adp=new ArrayAdapter<String>(getApplicationContext(),R.layout.activity_playlist,R.id.lv_activity_playlist,items);
        lv.setAdapter(adp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
startActivity(new Intent(getApplicationContext(),PlayerActivity.class).putExtra("pos",position).putExtra("songs",songs));
            }
        });
    }
    private ArrayList<File> findFiles(File root) {
        ArrayList<File> list = new ArrayList<File>();
        File[] files = root.listFiles();
        Log.d(msg," find files. ");
        for (File f : files) {
            if (f.isDirectory()) {
                list.addAll(findFiles(f));
            } else if (f.getName().endsWith(".mp3")) {
                list.add(f);
            }

        }
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_playlist, menu);
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
