package com.example.panlin_pan.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.util.Log;
/**
 * Created by panlin_pan on 8/5/2015.
 */
public class MyBroadcastReceiver1 extends BroadcastReceiver {
    String msg= "MyBroadcastReceiver1 ";
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Intent detected",Toast.LENGTH_LONG).show();

        String act = intent.getAction();
        Log.d(msg,"intent action: " + act);


    }
}
