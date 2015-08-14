package com.example.panlin_pan.myapplication.scenario_slidemenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.panlin_pan.myapplication.R;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by panlin_pan on 8/13/2015.
 */
public class MyHorizontalScrollView extends HorizontalScrollView {
    boolean inited = false;
    boolean once = false;
    LinearLayout wrapper;
    ViewGroup menu;
    ViewGroup content;
    int menuWidth;
    int screenWith;
    int menuRightPadding;
    private boolean isOpen;


    public MyHorizontalScrollView(Context context) {
        //super(context);
        this(context, null);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        //super(context, attrs);
        this(context, attrs, 0);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        menuRightPadding = 60;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyHorizontalScrollView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.MyHorizontalScrollView_rightPadding:
                    menuRightPadding = a.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50,
                                    context.getResources().getDisplayMetrics()));
                    break;
            }
        }
        a.recycle();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        screenWith = outMetrics.widthPixels;
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!inited) {
            getChildAt(0);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed)
            this.scrollTo(menuWidth, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (!once) {
            wrapper = (LinearLayout) getChildAt(0);
            menu = (ViewGroup) wrapper.getChildAt(0);
            content = (ViewGroup) wrapper.getChildAt(1);
            menuWidth = menu.getLayoutParams().width = screenWith - menuRightPadding;
            content.getLayoutParams().width = screenWith;

            once = true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                if (scrollX >= menuWidth / 2) {
                    this.smoothScrollTo(menuWidth, 0);
                    isOpen = false;
                } else {
                    this.smoothScrollTo(0, 0);
                    isOpen = true;
                }
                return true;
        }


        return super.onTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        float scale = l * 1.0f / menuWidth;

        float rightScale = 0.7f + 0.3f*scale;
        float leftScale = 1.0f - 0.3f*scale;
        float leftAlpha = 0.6f + 0.4f * (1-scale);

        ViewHelper.setTranslationX(menu, menuWidth * scale * 0.8f);
        /*ViewHelper.setScaleX(menu, leftScale);
        ViewHelper.setScaleY(menu, leftScale);*/
        ViewHelper.setAlpha(menu, leftAlpha);

        ViewHelper.setPivotX(content, 0);
        ViewHelper.setPivotY(content, content.getHeight() / 2);
        ViewHelper.setScaleX(content, rightScale);
        ViewHelper.setScaleY(content, rightScale);

    }

    public void openMenu() {
        if (isOpen) return;
        this.smoothScrollTo(0, 0);
        isOpen = true;
    }

    public void closeMenu() {
        if (!isOpen) return;
        this.smoothScrollTo(menuWidth, 0);
        isOpen = false;
    }

    public void toggle() {
        if (isOpen) closeMenu(); else openMenu();
    }
}
