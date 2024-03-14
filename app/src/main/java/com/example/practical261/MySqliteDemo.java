package com.example.practical261;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MySqliteDemo extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EmployeeDetails";
    private static final String TABLE_NAME = "EmployeeInfo";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_POST = "job";

    public MySqliteDemo(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + KEY_NAME + " TEXT ,"+ KEY_POST+" TEXT );" );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public long insert(String name, String post) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(KEY_NAME, name);
        content.put(KEY_POST, post);
        return db.insert(TABLE_NAME, null, content);
    }




}
