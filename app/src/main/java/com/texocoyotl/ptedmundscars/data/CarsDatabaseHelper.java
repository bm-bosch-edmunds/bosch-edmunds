package com.texocoyotl.ptedmundscars.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CarsDatabaseHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "edmunds.db";
    private static final int DATABASE_VERSION = 1;

    public CarsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Contract.CarsEntry.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contract.CarsEntry.TABLE_NAME);
        onCreate(db);
    }
}
