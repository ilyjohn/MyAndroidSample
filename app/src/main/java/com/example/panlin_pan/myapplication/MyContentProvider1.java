package com.example.panlin_pan.myapplication;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import java.sql.SQLException;
import java.util.HashMap;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

/**
 * Created by panlin_pan on 8/5/2015.
 */
public class MyContentProvider1 extends ContentProvider {
    static final String PROVIDER_NAME="com.example.panlin_pan.myapplication.MyContentProvider1";
    static final String URL="content://"+PROVIDER_NAME+"/students";
    static final Uri CONTENT_URI =Uri.parse(URL);

    static final String ID="_id";
    static final String Name="name";
    static final String GRADE="Grade";

    private static HashMap<String,String> Student_Project_Map;

    static final int Students = 1;
    static final int Student_ID=2;

    static final UriMatcher uriMatcher;
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME,"students",Students);
        uriMatcher.addURI(PROVIDER_NAME,"students/#",Student_ID);
    }


    private SQLiteDatabase db;
    static final String Database_Name="College";
    static final String Student_Table_Name="students";
    static final int Database_Version=1;
    static final String Create_DB_Table_Sql="" +
            "CREATE TABLE " + Student_Table_Name +
            "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "grade TEXT NOT NULL)"
            ;

    private static class DatabaseHelper extends  SQLiteOpenHelper{
        DatabaseHelper(Context context){
            super(context,Database_Name,null,Database_Version);
        }
        @Override public void onCreate(SQLiteDatabase db){
            db.execSQL(Create_DB_Table_Sql);
        }

        @Override public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + Student_Table_Name);
            onCreate(db);
        }
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper= new DatabaseHelper(context);
        /*
        create a write able database which will trigger its createion if it doesn't already exist.
         */
        db = dbHelper.getWritableDatabase();

        return db==null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(Student_Table_Name);
        switch (uriMatcher.match(uri)) {
            case Students:
                qb.setProjectionMap(Student_Project_Map);
                break;
            case Student_ID:
                qb.appendWhere(ID + "=" + uri.getPathSegments().get(1));
                break;
            default:
                throw new IllegalArgumentException("Unknown URI "+uri);
        }

        if(sortOrder==null|| sortOrder=="")
            sortOrder = Name;

        Cursor c = qb.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        c.setNotificationUri(getContext().getContentResolver(),uri);

        return c;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            /** * Get all student records */
            case Students:
                return "vnd.android.cursor.dir/vnd.example.students";
            /** * Get a particular student */
            case Student_ID:
                return "vnd.android.cursor.item/vnd.example.students";
            default: throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowId = db.insert(Student_Table_Name, "", values);
        if (rowId>0){
            Uri uri1= ContentUris.withAppendedId(CONTENT_URI,rowId);
            getContext().getContentResolver().notifyChange(uri1,null);
            return uri1;
        }
        //throw new SQLException(String.format("Failed to add record into %s", uri));
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case Students:
                count = db.delete(Student_Table_Name, selection, selectionArgs);
                break;
            case Student_ID:
                String id= uri.getPathSegments().get(1);
                count= db.delete(Student_Table_Name,ID+"="+id+
                                (!TextUtils.isEmpty(selection)?" AND (" +
                                selection+")":""),selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown Uri "+uri);
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)){
            case Students:
                count = db.update(Student_Table_Name,values,selection,selectionArgs);
                break;
            case Student_ID:
                count=db.update(Student_Table_Name,values,ID+"="+uri.getPathSegments().get(1)
                +(!TextUtils.isEmpty(selection)?" AND (" +
                        selection+")":""),selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown uri "+uri);

        }
        getContext().getContentResolver().notifyChange(uri,null);

        return count;
    }
}
