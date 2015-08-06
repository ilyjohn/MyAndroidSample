package com.example.panlin_pan.myapplication;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;

public class MainActivity extends ActionBarActivity {
    String msg = "Android : ";
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, " The onCreate() event");


    }
    @Override protected void onStart() {
        super.onStart(); Log.d(msg, "The onStart() event");
    }
    /** Called when the activity has become visible. */
    @Override protected void onResume() {
        super.onResume(); Log.d(msg, "The onResume() event");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(msg, "Main destroy.");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            startActivity(new Intent("android.intent.action.Sweet"));
            return true;
        }else if (id == R.id.menuSweet){
            Intent intent = new Intent(getApplicationContext(),BluetoothActivity.class);
            startActivity(intent);
        }else if (id == R.id.menuToast){
            startActivity(new Intent(getApplicationContext(),WifiActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public void getBluetoothActivity(View view){
        Intent intent = new Intent(getApplicationContext(),BluetoothActivity.class);
        startActivity(intent);
    }

    public void getWifiActivity(View view){
        startActivity(new Intent(getApplicationContext(),WifiActivity.class));
    }
    public void getPlaylistActivity(View view){
        startActivity(new Intent(getApplicationContext(),PlaylistActivity.class));
    }
    public void getStudentActivity(View view){
        startActivity(new Intent(getApplicationContext(),StudentActivity.class));
    }

    public void startService(View view){
        startService(new Intent(getBaseContext(), MyService1.class));
    }

    public void stopService(View view){
        stopService(new Intent(getBaseContext(), MyService1.class));
    }

    public void myBroadcastIntent(View view){
        Intent i = new Intent();
        i.setAction("com.panlin.Custom_Intent");
        sendBroadcast(i);
    }
}
