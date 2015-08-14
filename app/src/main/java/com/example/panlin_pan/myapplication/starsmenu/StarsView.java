package com.example.panlin_pan.myapplication.starsmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by panlin_pan on 8/14/2015.
 */
public class StarsView extends ViewGroup {
    Point[][] points;


    public StarsView(Context context) {
        this(context, null);
    }

    public StarsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StarsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);



    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
