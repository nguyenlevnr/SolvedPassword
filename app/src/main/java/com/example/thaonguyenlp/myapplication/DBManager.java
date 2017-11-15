package com.example.thaonguyenlp.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thaonguyenlp on 11/7/2017.
 */

public class DBManager extends SQLiteOpenHelper {
    static final String D_NAME="SCORES";
    static final int D_VERSION=1;
    static final String T_NAME="user";
    static final String K_ID="_id";
    static final String K_NAME="NAME";
    static final String K_SCORE="SCORE";


    public DBManager(Context context) {
        super(context, D_NAME, null, D_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table  "+ T_NAME +
                "( " +
                K_ID + " integer primary key autoincrement, " +
                K_NAME+" text, " +
                K_SCORE+" text " +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+T_NAME);
        onCreate(db);
    }

    public void saveScore(String name, String score)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(K_NAME,name);
        values.put(K_SCORE,score);
        db.insert(T_NAME, null, values);
    }

    public Cursor getAllScore()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from "+T_NAME, null);

        if(c.moveToLast())
        {
            do {
                if(Integer.parseInt(c.getString(0)) > 7){
                    int i = Integer.parseInt(c.getString(0))- 7;
                    if(isExist(i)){
                        deleteScore(i);
                    }
                }
            }
            while(c.moveToPrevious());
        }

        Cursor cur=db.rawQuery("select * from "+T_NAME, null);
        return cur;
    }

    public boolean isExist(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + T_NAME + " WHERE " + K_ID + " = " + id, null);
        boolean exist = (cur.getCount() > 0);
        return exist;
    }

    public void deleteScore(int x)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(T_NAME,"_id=?",new String[]{x+""});
    }
}

