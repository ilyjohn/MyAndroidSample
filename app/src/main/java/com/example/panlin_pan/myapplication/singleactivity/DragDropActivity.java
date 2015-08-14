package com.example.panlin_pan.myapplication.singleactivity;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.panlin_pan.myapplication.R;


public class DragDropActivity extends Activity {
    String msg = "DragDropActivity : ";
    ImageView img;
    RelativeLayout.LayoutParams parameters;
    final Activity self = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop);
        findViewById(R.id.appleText).setOnLongClickListener(longListener);
        findViewById(R.id.bananaText).setOnLongClickListener(longListener);
        findViewById(R.id.pearText).setOnLongClickListener(longListener);
        findViewById(R.id.orangeText).setOnLongClickListener(longListener);

        findViewById(R.id.dropTarget).setOnDragListener(dragListener);
        /*img = (ImageView)findViewById(R.id.imageView);
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item= new ClipData.Item((CharSequence)v.getTag());
                String[] mineTypes= {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData dragData = new ClipData(v.getTag().toString(),mineTypes,item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img);
                //v.startDrag(dragData,myShadow,null,0);

                return true;
            }
        });

        img.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                            // As an example of what your application might do,
                            // applies a blue color tint to the View to indicate that it can accept
                            // data.
                            //v.setColorFilter(Color.BLUE);

                            // Invalidate the view to force a redraw in the new tint
                            v.invalidate();

                            // returns true to indicate that the View can accept the dragged data.
                            return true;

                        }
                        parameters = (RelativeLayout.LayoutParams) v.getLayoutParams();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        v.invalidate();
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                        x = (int) event.getX();
                        y = (int) event.getY();
                        parameters.leftMargin = x;
                        parameters.topMargin = y;
                        v.setLayoutParams(parameters);
                        v.invalidate();
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
                        if (event.getResult()) {
                            Toast.makeText(self, "The drop was handled.", Toast.LENGTH_LONG);

                        } else {
                            Toast.makeText(self, "The drop didn't work.", Toast.LENGTH_LONG);

                        }
                        break;
                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "Action is DragEvent.ACTION_DROP");
                        v.invalidate();
                        view = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup)view.getParent();
                        owner.removeView(view);
                        RelativeLayout container = (RelativeLayout) v;
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);

                        ClipData.Item item = event.getClipData().getItemAt(0);


                        // Displays a message containing the dragged data.
                        Toast.makeText(self, "Dragged data is " + item.getText(), Toast.LENGTH_LONG);
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
        });*/
    }

    View.OnLongClickListener longListener = new View.OnLongClickListener()
    {
        @Override
        public boolean onLongClick(View v)
        {
            TextView fruit = (TextView) v;
            Toast.makeText(DragDropActivity.this, "Text long clicked - " +fruit.getText() , Toast.LENGTH_SHORT).show();

            View.DragShadowBuilder myShadowBuilder = new MyShadowBuilder(v);

            ClipData data = ClipData.newPlainText("", "");
            v.startDrag(data, myShadowBuilder, fruit, 0);

            return true;
        }

    };

    View.OnDragListener dragListener = new View.OnDragListener()
    {
        @Override
        public boolean onDrag(View v, DragEvent event)
        {
            int dragEvent = event.getAction();
            TextView dropText = (TextView) v;

            switch(dragEvent)
            {
                case DragEvent.ACTION_DRAG_ENTERED:
                    //dropText.setTextColor(Color.GREEN);
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    //dropText.setTextColor(Color.RED);
                    break;

                case DragEvent.ACTION_DROP:
                    TextView draggedText = (TextView)event.getLocalState();
                    dropText.setText(draggedText.getText());
                    break;
            }

            return true;
        }

    };


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

    private class MyShadowBuilder extends View.DragShadowBuilder
    {
        private Drawable shadow;

        public MyShadowBuilder(View v)
        {
            super(v);
            shadow = new ColorDrawable(Color.LTGRAY);
        }

        @Override
        public void onDrawShadow(Canvas canvas)
        {
            shadow.draw(canvas);
        }

        @Override
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint)
        {
            int height, width;
            height = (int) getView().getHeight()/2;
            width = (int) getView().getHeight()/2;

            shadow.setBounds(0, 0, width, height);

            shadowSize.set(width, height);
            shadowTouchPoint.set(width/2, height/2);
        }

    }
}
