package com.example.panlin_pan.myapplication.starsmenu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.panlin_pan.myapplication.R;

import java.util.ArrayList;

public class StarsHolderActivity extends ActionBarActivity {
    StarsView starsView1, starsView2, starsView3, starsView4;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stars_holder);

        lv = (ListView) findViewById(R.id.listView);
        starsView1 = (StarsView) findViewById(R.id.starsMenu1);
        starsView2 = (StarsView) findViewById(R.id.starsMenu2);
        starsView3 = (StarsView) findViewById(R.id.starsMenu3);
        starsView4 = (StarsView) findViewById(R.id.starsMenu4);

        initEvents();

        initListView();

        animateListView();
    }

    private void initListView() {
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            arrayList.add((char) i);
        }
        ArrayAdapter<Character> array2ListView = new ArrayAdapter<Character>(this
                , android.R.layout.simple_list_item_activated_1, arrayList);
        lv.setAdapter(array2ListView);

        Button btn = new Button(this);
        btn.setText("header");
        lv.addHeaderView(btn);
    }

    private void animateListView() {
        LayoutAnimationController controller = new LayoutAnimationController(
                AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_top));
        controller.setOrder(LayoutAnimationController.ORDER_REVERSE);
        controller.setDelay(1.5f);
        lv.setLayoutAnimation(controller);
        lv.startLayoutAnimation();
    }
    public StarsView.OnMenuItemClickListener onMenuItemClick =new StarsView.OnMenuItemClickListener() {
        @Override
        public void onMenuItemClick(View v, int pos) {
            Toast.makeText(StarsHolderActivity.this, pos + ":" + v.getTag(), Toast.LENGTH_SHORT).show();

        }
    };
    private void initEvents() {
        starsView1.setOnMenuItemClickListener(onMenuItemClick);
        starsView2.setOnMenuItemClickListener(onMenuItemClick);
        starsView3.setOnMenuItemClickListener(onMenuItemClick);
        starsView4.setOnMenuItemClickListener(onMenuItemClick);

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if (starsView1.isOpen)
                    starsView1.toggleStarsMenu(1600);

                if (starsView2.isOpen)
                    starsView2.toggleStarsMenu(1600);

                if (starsView3.isOpen)
                    starsView3.toggleStarsMenu(1600);

                if (starsView4.isOpen)
                    starsView4.toggleStarsMenu(1600);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stars_holder, menu);
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
