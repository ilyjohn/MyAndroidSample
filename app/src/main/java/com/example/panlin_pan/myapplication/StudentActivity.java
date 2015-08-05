package com.example.panlin_pan.myapplication;

import android.content.ContentValues;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class StudentActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student, menu);
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

    public void onClickAddName(View view){
        ContentValues values = new ContentValues();
        values.put(MyContentProvider1.Name,
                ((EditText)findViewById(R.id.txtName)).getText().toString());

        values.put(MyContentProvider1.GRADE,
                ((EditText)findViewById(R.id.txtGrade)).getText().toString());

        Uri uri = getContentResolver().insert(MyContentProvider1.CONTENT_URI,values);

        Toast.makeText(getBaseContext(),uri.toString(),Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view){
        String URL = "content://com.example.panlin_pan.myapplication.MyContentProvider1/students";
        Uri students = Uri.parse(URL);
        Cursor c;// = managedQuery(students,null,null,null,"name");
        c = getContentResolver().query(students,null,null,null,"name");
        if (c.moveToFirst()){
            do {
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(MyContentProvider1.ID))+
                ", "+c.getString(c.getColumnIndex(MyContentProvider1.Name))+
                ", "+c.getString(c.getColumnIndex(MyContentProvider1.GRADE)),Toast.LENGTH_LONG).show();

            }while (c.moveToNext());
        }
        c.close();
    }
}
