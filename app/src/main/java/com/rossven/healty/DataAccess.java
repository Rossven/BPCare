package com.rossven.healty;

/*
public int id;
public String name;
public long diastolic;
public long Systolic;
public Date date;
*/

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataAccess {

    private SQLiteDatabase database;
    private final Context context;
    private final DataAccessHelper dataAccessHelper;

    public static String INFID_COLUMN = "_id";
    public static String INFNAME_COLUMN = "NAME";
    public static String INFDIASTOLIC_COLUMN = "DIASTOLIC";
    public static String INFSYSTOLIC_COLUMN = "SYSTOLIC";
    public static String INFDATE_COLUMN = "DATE";
    public static String TABLE_NAME = "INFS";

    DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
    DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm");
    String dateD,dateS;

    public DataAccess(Context c){
        context = c;
        dataAccessHelper = new DataAccessHelper(context);
    }

    public void closeDatabase(){
        database.close();
    }

    public void connectToDatabase() throws SQLiteException {
        try{
            database = dataAccessHelper.getWritableDatabase();
        }
        catch (SQLiteException ex){
            database = dataAccessHelper.getReadableDatabase();
        }
    }

    public long addInf(Informations informations){
        try {
            dateS = String.valueOf(informations.date);
            dateD = (dateFormat.format(formatter.parse(dateS)));

            ContentValues newContentValue = new ContentValues();
            newContentValue.put(INFNAME_COLUMN, informations.name );
            newContentValue.put(INFDIASTOLIC_COLUMN, informations.diastolic);
            newContentValue.put(INFSYSTOLIC_COLUMN, informations.Systolic);
            newContentValue.put(INFDATE_COLUMN, dateD);

            return database.insert(TABLE_NAME, null, newContentValue);
        }
        catch (SQLiteException | ParseException ex){
            return -1;
        }
    }

    public Cursor getAllInf(){
        return database.query(TABLE_NAME, new String[]{INFID_COLUMN, INFNAME_COLUMN, INFDIASTOLIC_COLUMN, INFSYSTOLIC_COLUMN, INFDATE_COLUMN},
                null, null, null, null, null);
    }


    public void deleteAllData(){
        SQLiteDatabase db = this.dataAccessHelper.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}
