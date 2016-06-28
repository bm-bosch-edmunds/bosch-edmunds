package com.texocoyotl.ptedmundscars.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class Contract {

    public static final String CONTENT_AUTHORITY = "com.texocoyotl.ptedmundscars";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_CARS = "cars";
    public static final String PATH_MAKERS = "makers";

    public static final class CarsEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_CARS).build();
        public static final Uri MAKERS_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MAKERS).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CARS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CARS;
        public static final String MAKERS_CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MAKERS;

        public static final String TABLE_NAME = "cars";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_MANUFACTURER= "manufacturer";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_YEAR = "year";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT ," +
                COLUMN_MANUFACTURER + " TEXT," +
                COLUMN_YEAR + " TEXT" +
                ")";


    }


    public static final class ModelsListQuery {
        public static final String[] COLUMNS = {
                CarsEntry._ID,
                CarsEntry.COLUMN_NAME
        };

        public static final int COLNUM_ID = 0;
        public static final int COLNUM_NAME = 1;
    }
}