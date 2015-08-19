package com.example.panlin_pan.myapplication.starsmenu;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Panlin_Pan on 8/19/2015.
 */
public class MyListView extends ListView implements AbsListView.OnScrollListener {
    TextView header, footer;

    public MyListView(Context context) {
        this(context, null);
    }

    public MyListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        header = new TextView(getContext());
        header.setText("pull down for refresh.");
        this.addHeaderView(header);
        header.setBackgroundColor(Color.GREEN);
        header.setVisibility(View.GONE);

        footer = new TextView(getContext());
        footer.setText("pull up for load more.");
        this.addFooterView(footer);
        footer.setBackgroundColor(Color.GREEN);
        footer.setVisibility(View.GONE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        float startX = 0f, startY = 0f;
        boolean moveDone = false;
        //return super.onTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                moveDone = startY - ev.getY() < 0;
                if (moveDone) {
                    header.setVisibility(View.VISIBLE);
                    footer.setVisibility(View.GONE);
                }else {
                    header.setVisibility(View.GONE);
                    footer.setVisibility(View.VISIBLE);
                }

                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
