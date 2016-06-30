package com.texocoyotl.ptedmundscars.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;


public class CarsContentProvider extends ContentProvider {
    static final int MATCH_MODELS = 100;
    static final int MATCH_MAKERS = 101;
    static final int MATCH_STYLES = 102;
    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private CarsDatabaseHelper mDatabaseHelper;

    public CarsContentProvider() {
    }

    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = Contract.CONTENT_AUTHORITY;

        matcher.addURI(authority, Contract.PATH_CARS, MATCH_MODELS);
        matcher.addURI(authority, Contract.PATH_MAKERS, MATCH_MAKERS);
        matcher.addURI(authority, Contract.PATH_STYLES, MATCH_STYLES);
        return matcher;
    }

    @Override
    public boolean onCreate() {
        mDatabaseHelper = new CarsDatabaseHelper(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);

        switch (match) {
            case MATCH_MAKERS:
            case MATCH_MODELS:
                return Contract.CarsEntry.CONTENT_TYPE;
            case MATCH_STYLES:
                return Contract.StylesEntry.CONTENT_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        int match = sUriMatcher.match(uri);
        if (match == MATCH_MAKERS ) {

            return mDatabaseHelper.getReadableDatabase().rawQuery(Contract.CarsEntry.MAKERS_QUERY, null);

        }
        else if (match == MATCH_MODELS ) {

            return mDatabaseHelper.getReadableDatabase().query(
                    Contract.CarsEntry.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder
            );
        }
        else if (match == MATCH_STYLES){
            return mDatabaseHelper.getReadableDatabase().query(
                    Contract.StylesEntry.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder
            );
        }
        else throw new UnsupportedOperationException("Unknown uri: " + uri);

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase sqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int count = 0;
        Uri returnUri;
        if ( null == selection ) selection = "1";
        switch (match) {
            case MATCH_MODELS:
                count = sqLiteDatabase.delete(Contract.CarsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case MATCH_STYLES:
                count = sqLiteDatabase.delete(Contract.StylesEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        if (count > 0) getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        final SQLiteDatabase sqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        long resultId;
        Uri returnUri;

        switch (match) {
            case MATCH_MODELS:
                resultId = sqLiteDatabase.insert(Contract.CarsEntry.TABLE_NAME, null, values);
                if (resultId > 0) {
                    returnUri = ContentUris.withAppendedId(Contract.CarsEntry.CONTENT_URI, resultId);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
            case MATCH_STYLES:
                resultId = sqLiteDatabase.insert(Contract.StylesEntry.TABLE_NAME, null, values);
                if (resultId > 0) {
                    returnUri = ContentUris.withAppendedId(Contract.StylesEntry.CONTENT_URI, resultId);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }



    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        final SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int returnCount = 0;
        switch (match) {
            case MATCH_MODELS:
                db.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(Contract.CarsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            case MATCH_STYLES:
                db.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(Contract.StylesEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            default:
                return super.bulkInsert(uri, values);
        }
    }

}
