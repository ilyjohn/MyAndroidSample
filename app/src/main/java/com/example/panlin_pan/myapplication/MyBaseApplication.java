package com.example.panlin_pan.myapplication;

import android.app.Application;

/**
 * Created by panlin_pan on 8/13/2015.
 */
public class MyBaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public MyBaseApplication() {
        super();
    }
}
