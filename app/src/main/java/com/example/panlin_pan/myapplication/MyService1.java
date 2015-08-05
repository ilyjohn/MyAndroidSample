package com.example.panlin_pan.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import android.util.Log;
/**
 * Created by panlin_pan on 8/5/2015.
 */
public class MyService1 extends Service {
    String msg="My Service1: ";
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent,int flags, int startId){
        Toast.makeText(this,"Service started",Toast.LENGTH_LONG).show();
        Log.d(msg,"onStartCommand");
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Service destroyed",Toast.LENGTH_LONG).show();
        Log.d(msg,"onDestroy");
    }

}
