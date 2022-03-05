package com.rossven.healty;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
public int id;
public String name;
public long diastolic;
public long Systolic;
public Date date;
*/


public class DataAccessHelper extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME = "Information.db";
    private  static final int DATABASE_VERSION = 2 ;

    public DataAccessHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE INFS ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NAME TEXT NOT NULL, DIASTOLIC INTEGER NOT NULL, SYSTOLIC INTEGER NOT NULL, DATE DATE NOT NULL);" );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVers, int newVers){
        db.execSQL("DROP TABLE IF EXISTS INFS");
        onCreate(db);
    }

    Cursor readAllData(){

        String query = "SELECT * FROM " + "INFS";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }

}

