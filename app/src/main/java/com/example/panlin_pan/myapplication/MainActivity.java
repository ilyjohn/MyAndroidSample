package com.example.panlin_pan.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;
import android.widget.Button;

import com.example.panlin_pan.myapplication.scenario_rotate.MyRotateActivity;
import com.example.panlin_pan.myapplication.scenario_master_details.FragmentLayout;
import com.example.panlin_pan.myapplication.scenario_master_details.MapActivity;
import com.example.panlin_pan.myapplication.singleactivity.BluetoothActivity;
import com.example.panlin_pan.myapplication.singleactivity.DragDropActivity;
import com.example.panlin_pan.myapplication.singleactivity.PlaylistActivity;
import com.example.panlin_pan.myapplication.scenario_slidemenu.SlideContainer;
import com.example.panlin_pan.myapplication.singleactivity.StudentActivity;
import com.example.panlin_pan.myapplication.singleactivity.WifiActivity;
import com.example.panlin_pan.myapplication.starsmenu.StarsHolderActivity;

public class MainActivity extends ActionBarActivity {
    String msg = "Android : ";


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, " The onCreate() event");
        Button btnDragDropTest = (Button)findViewById(R.id.btnDragDropTest);
        btnDragDropTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DragDropActivity.class));
            }
        });

        Button btnLandPort = (Button)findViewById(R.id.btnLandPort);
        btnLandPort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MyRotateActivity.class));
            }
        });


        Button btnSendNotify = (Button)findViewById(R.id.btnSendNotify);
        final Activity self = this;
        btnSendNotify.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(self);
                builder.setSmallIcon(R.drawable.notification_template_icon_bg);
                builder.setContentTitle("Alert");
                builder.setContentText("this is notif.. details");

                Intent resultI= new Intent(self, WifiActivity.class);
                TaskStackBuilder taskStackBuilder=TaskStackBuilder.create(self);
                taskStackBuilder.addParentStack(WifiActivity.class);

                taskStackBuilder.addNextIntent(resultI);
                PendingIntent pi=taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pi);

                NotificationManager notificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1,builder.build());

            }
        });
        Button btnMainDetails = (Button)findViewById(R.id.btnMainDetails);
        btnMainDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FragmentLayout.class));
            }
        });

        Button btnMap = (Button)findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MapActivity.class));
            }
        });


        Button btnMenu = (Button)findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SlideContainer.class));
            }
        });

        Button btnStarMenu = (Button)findViewById(R.id.btnStarMenu);
        btnStarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),StarsHolderActivity.class));
            }
        });
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
