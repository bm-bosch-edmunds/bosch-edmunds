package com.texocoyotl.ptedmundscars.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class Contract {

    public static final String CONTENT_AUTHORITY = "com.texocoyotl.ptedmundscars";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_CARS = "cars";
    public static final String PATH_MAKERS = "makers";
    public static final String PATH_STYLES = "styles";

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
        public static final String COLUMN_MODEL_ID = "modelId";
        public static final String COLUMN_MANUFACTURER= "manufacturer";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_YEAR = "year";
        public static final String COLUMN_WEB_NAME = "web_name";
        public static final String COLUMN_WEB_MANUFACTURER = "web_manufacturer";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_MODEL_ID + " TEXT, " +
                COLUMN_NAME + " TEXT ," +
                COLUMN_MANUFACTURER + " TEXT," +
                COLUMN_WEB_NAME + " TEXT ," +
                COLUMN_WEB_MANUFACTURER + " TEXT," +
                COLUMN_YEAR + " TEXT" +
                ")";

        public static final String MAKERS_QUERY =
                "SELECT " + COLUMN_MANUFACTURER + " AS _id, " +
                        COLUMN_MANUFACTURER + " AS name, " +
                        COLUMN_WEB_MANUFACTURER + " AS web_name FROM " +
                        TABLE_NAME + " GROUP BY " +
                        COLUMN_MANUFACTURER + ", " +
                        COLUMN_WEB_MANUFACTURER;

        public static final int MAKERS_QUERY_WEB_MANUFACTURERS_COLNUM = 2;

    }

    public static final class StylesEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_STYLES).build();


        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STYLES;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STYLES;

        public static final String TABLE_NAME = "styles";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_STYLE_ID = "style_id";
        public static final String COLUMN_MAKER = "maker";
        public static final String COLUMN_MODEL = "model";
        public static final String COLUMN_YEAR = "year";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_SUBMODEL = "submodel";
        public static final String COLUMN_MARKET = "market";
        public static final String COLUMN_SIZE = "size";
        public static final String COLUMN_CAT_STYLE = "cat_size";
        public static final String COLUMN_DOORS = "doors";
        public static final String COLUMN_TRANSMISSION = "transmission";
        public static final String COLUMN_SPEEDS = "speeds";
        public static final String COLUMN_ENGINE_NAME = "engine_name";
        public static final String COLUMN_ENGINE_TYPE = "engine_type";
        public static final String COLUMN_CYLINDERS = "cylinders";
        public static final String COLUMN_ENGINE_SIZE = "engine_size";
        public static final String COLUMN_HORSE_POWER = "horse_power";
        public static final String COLUMN_MPG_HIGHWAY = "mpg_highway";
        public static final String COLUMN_MPG_CITY = "mpg_city";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_STYLE_ID + " TEXT, " +
                COLUMN_MAKER + " TEXT, " +
                COLUMN_MODEL + " TEXT, " +
                COLUMN_YEAR + " TEXT, " +
                COLUMN_NAME + " TEXT ," +
                COLUMN_TYPE + " TEXT," +
                COLUMN_SUBMODEL + " TEXT" +
                ")";

        public static final class DashBoardQuery {
            public static final String[] COLUMNS = {
                    COLUMN_ID,
                    COLUMN_STYLE_ID,
                    COLUMN_YEAR,
                    COLUMN_NAME,
                    COLUMN_TYPE,
                    COLUMN_SUBMODEL
            };

            public static final int COLNUM_ID = 0;
            public static final int COLNUM_STYLE_ID = 1;
            public static final int COLNUM_YEAR = 2;
            public static final int COLNUM_NAME = 3;
            public static final int COLNUM_TYPE = 4;
            public static final int COLNUM_SUBMODEL = 5;

            public static final String SELECTION = COLUMN_MAKER + "= ? AND " + COLUMN_MODEL + "= ?";
        }

    }


    public static final class ModelsListQuery {
        public static final String[] COLUMNS = {
                CarsEntry.COLUMN_ID,
                CarsEntry.COLUMN_MODEL_ID,
                CarsEntry.COLUMN_NAME,
                CarsEntry.COLUMN_WEB_NAME
        };

        public static final int COLNUM_ID = 0;
        public static final int COLNUM_MODEL_ID = 1;
        public static final int COLNUM_NAME = 2;
        public static final int COLNUM_WEB_NAME = 3;
    }


}