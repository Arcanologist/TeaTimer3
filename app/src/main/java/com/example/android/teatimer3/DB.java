package com.example.android.teatimer3;

import android.provider.BaseColumns;

/**
 * Created by maksk on 6/24/2017.
 */

public final class DB {
    private DB() {
    }

    public static class Tea implements BaseColumns {
        public static final String TABLE_NAME = "tea";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TEMP = "temp";
        public static final String COLUMN_TIME = "time";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_TEMP + " INTEGER, " +
                COLUMN_TIME + " INTEGER" + ")";
    }
}
