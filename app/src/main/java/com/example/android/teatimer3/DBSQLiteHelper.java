package com.example.android.teatimer3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maksk on 6/24/2017.
 */

public class DBSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "tea_db";

    public DBSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DB.Tea.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB.Tea.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    public List<Tea> getDataFromDB(){
        List<Tea> modelList = new ArrayList<DatabaseModel>();
        String query = "select * from tea";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Tea model = new Tea();
                model.setName(cursor.getString(0));
                model.setTemp(cursor.getString(1));
                model.setTime(cursor.getString(2));
                modelList.add(model);
            }while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());


        return modelList;
    }



}
