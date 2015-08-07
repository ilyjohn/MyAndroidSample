package com.example.panlin_pan.myapplication;

import android.content.ClipData;
import android.content.ClipDescription;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class DragDropActivity extends ActionBarActivity {
    String msg = "DragDropActivity : ";
    ImageView img;
    RelativeLayout.LayoutParams parameters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop);

        img = (ImageView)findViewById(R.id.imageView);
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item= new ClipData.Item((CharSequence)v.getTag());
                String[] mineTypes= {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData dragData = new ClipData(v.getTag().toString(),mineTypes,item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img);
                v.startDrag(dragData,myShadow,null,0);

                return true;
            }
        });

        img.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:

                        parameters = (RelativeLayout.LayoutParams) v.getLayoutParams();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                        x = (int) event.getX();
                        y = (int) event.getY();
                        parameters.leftMargin = x;
                        parameters.topMargin = y;
                        v.setLayoutParams(parameters);
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                        x = (int) event.getX();
                        y = (int) event.getY();
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");
                        break;
                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "Action is DragEvent.ACTION_DROP");

                        view = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup)view.getParent();
                        owner.removeView(view);
                        RelativeLayout container = (RelativeLayout) v;
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);


                        break;
                    default:
                        break;
                }

                return true;
            }
        });

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img);
                    img.startDrag(data, shadowBuilder, img, 0);

                    img.setVisibility(View.VISIBLE);
                    return true;
                } else
                    return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drag_drop, menu);
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
