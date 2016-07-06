package com.texocoyotl.ptedmundscars.views.activities.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.texocoyotl.ptedmundscars.App;
import com.texocoyotl.ptedmundscars.BuildConfig;
import com.texocoyotl.ptedmundscars.views.activities.login.LoginActivity;
import com.texocoyotl.ptedmundscars.R;
import com.texocoyotl.ptedmundscars.views.activities.detail.DetailActivity;
import com.texocoyotl.ptedmundscars.adapters.CarsRecyclerViewAdapter;
import com.texocoyotl.ptedmundscars.retrofit.APIService;
import com.texocoyotl.ptedmundscars.api_pojos.CarsResult;
import com.texocoyotl.ptedmundscars.api_pojos.Make;
import com.texocoyotl.ptedmundscars.api_pojos.Model;
import com.texocoyotl.ptedmundscars.api_pojos.Style;
import com.texocoyotl.ptedmundscars.api_pojos.Year;
import com.texocoyotl.ptedmundscars.data.Contract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class DashBoardActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor>,
        OnStylesListInteractionListener {

    public static final String STYLE_ID_PARAM = "STYLE_ID_PARAM";
    private static final String TAG = "DashBoardTAG_";
    private static final int MAKERS_LIST_LOADER = 0;
    private static final int MODELS_LIST_LOADER = 1;
    private static final int STYLES_LIST_LOADER = 2;
    private static final String MAKER_NAME_KEY = "MAKER_NAME_KEY";
    private static final String STYLES_MAKER_PARAM = "STYLES_MAKER_PARAM";
    private static final String STYLES_MODEL_PARAM = "STYLES_MODEL_PARAM";
    private static final String lastDownloadKey = "LAST_DOWNLOAD";
    private static final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
    RelativeLayout mLoadingPanel;
    private Subscription mCarsListSubscription;
    private CarsRecyclerViewAdapter mStylesListAdapter;
    private SimpleCursorAdapter mMakersSpinnerAdapter;
    private SimpleCursorAdapter mModelsSpinnerAdapter;
    private Spinner mModelsSpinner;
    private Subscription mStylesListSubscription;

    @Inject
    APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        ((App) getApplication()).getRetroFitComponent().inject(this);

        initWidgets();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        long lastSync = prefs.getLong(lastDownloadKey, 0);
        long timestamp = System.currentTimeMillis();
        if (timestamp - lastSync >= DAY_IN_MILLIS) {

            getContentResolver().delete(Contract.CarsEntry.CONTENT_URI, null, null);
            getContentResolver().delete(Contract.StylesEntry.CONTENT_URI, null, null);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putLong(lastDownloadKey, timestamp);
            editor.apply();
        }

        getSupportLoaderManager().initLoader(MAKERS_LIST_LOADER, null, this);

    }

    private void initWidgets() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mLoadingPanel = (RelativeLayout) findViewById(R.id.loadingPanel);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.models_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mStylesListAdapter = new CarsRecyclerViewAdapter(this, null);
        mRecyclerView.setAdapter(mStylesListAdapter);

        String[] from = new String[] {"name", "name"};
        int[] to = new int[] {R.id.makers_spinner_image, R.id.makers_spinner_name};
        mMakersSpinnerAdapter = new SimpleCursorAdapter(this, R.layout.makers_spinner_row, null, from, to, 1);
        mMakersSpinnerAdapter.setDropDownViewResource(R.layout.makers_spinner_row);
        mMakersSpinnerAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder(){
            /** Binds the Cursor column defined by the specified index to the specified view */
            public boolean setViewValue(View view, Cursor cursor, int columnIndex){
                if(view.getId() == R.id.makers_spinner_image){
                    ImageView img =((ImageView)view);
                    String logo = cursor.getString(columnIndex);
                    int subs = getResources().getIdentifier("logo_substitution_" + logo, "string", getPackageName());
                    if (subs > 0)
                        logo = getString(subs);
                    else
                        logo = logo.replace(" ", "-");

                    Picasso.with(DashBoardActivity.this)
                            .load(BuildConfig.BASE_LOGOS_URL + logo + "-logo-1.jpg")
                            .into(img);
                    return true; //true because the data was bound to the view
                }

                return false;
            }
        });

        Spinner mMakersSpinner = (Spinner) this.findViewById(R.id.dashboard_makers);
        mMakersSpinner.setAdapter(mMakersSpinnerAdapter);
        mMakersSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String  maker = ((TextView) view.findViewById(R.id.makers_spinner_name)).getText().toString();

                Bundle params = new Bundle();
                params.putString(MAKER_NAME_KEY, maker);
                getSupportLoaderManager().restartLoader(MODELS_LIST_LOADER, params, DashBoardActivity.this);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        from = new String[] {"name"};
        to = new int[] {android.R.id.text1};
        mModelsSpinnerAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, null, from, to);
        mModelsSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mModelsSpinner = (Spinner) this.findViewById(R.id.dashboard_models);
        mModelsSpinner.setAdapter(mModelsSpinnerAdapter);

    }

    @Override
    public void onDestroy() {
        if (mCarsListSubscription != null)
            mCarsListSubscription.unsubscribe();
        if (mStylesListSubscription != null)
            mStylesListSubscription.unsubscribe();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dash_board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            Intent i = new Intent(this, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(String styleId) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(STYLE_ID_PARAM, styleId);
        startActivity(i);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        switch(id) {
            case MAKERS_LIST_LOADER:
                return new CursorLoader(
                        this,
                        Contract.CarsEntry.MAKERS_URI,
                        null,
                        null,
                        null,
                        null
                );
            case MODELS_LIST_LOADER:
                return new CursorLoader(
                        this,
                        Contract.CarsEntry.CONTENT_URI,
                        Contract.ModelsListQuery.COLUMNS,
                        Contract.CarsEntry.COLUMN_MANUFACTURER + "= ?",
                        new String[]{args.getString(MAKER_NAME_KEY)},
                        null
                );
            case STYLES_LIST_LOADER:
                return new CursorLoader(
                        this,
                        Contract.StylesEntry.CONTENT_URI,
                        Contract.StylesEntry.DashBoardQuery.COLUMNS,
                        Contract.StylesEntry.DashBoardQuery.SELECTION,
                        new String[]{
                                args.getString(STYLES_MAKER_PARAM),
                                args.getString(STYLES_MODEL_PARAM)
                        },
                        null
                );
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        if (data.moveToFirst()) {
            mLoadingPanel.setVisibility(View.GONE);
            Log.d(TAG, "logRows: " + data.getCount());

            if (loader.getId() == MAKERS_LIST_LOADER)
                mMakersSpinnerAdapter.swapCursor(data);
            else if (loader.getId() == MODELS_LIST_LOADER) {
                mModelsSpinnerAdapter.swapCursor(data);
                mModelsSpinner.setSelection(0);
            }
            else if (loader.getId() == STYLES_LIST_LOADER){
                mStylesListAdapter.swapCursor(data);
            }

        } else {
            if (loader.getId() == MAKERS_LIST_LOADER || loader.getId() == MODELS_LIST_LOADER)
                downloadCarListData();
            else if (loader.getId() == STYLES_LIST_LOADER)
                downloadStylesListData();
        }

    }



    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void downloadCarListData() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork == null) {
            Snackbar.make(mLoadingPanel, R.string.snackbar_no_internet_initial, Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbar_action_retry), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            downloadCarListData();
                        }
                    })
                    .show();
            return;
        }

        Observable<CarsResult> mCarsListAPIcall = mAPIService.getCarsList();

        mCarsListSubscription = mCarsListAPIcall
                .subscribeOn(Schedulers.newThread())
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d(TAG, "onError: " + throwable.getMessage());
                    }
                })
                .map(new Func1<CarsResult, Integer>() {
                    @Override
                    public Integer call(CarsResult result) {

                        List<ContentValues> values = new ArrayList<ContentValues>();
                        List<Make> items = result.getMakes();

                        for (int i = 0; i < items.size(); i++) {
                            Make make = items.get(i);

                            for(Model model: make.getModels()){
                                ContentValues data = new ContentValues();
                                String capName = Character.toUpperCase(model.getName().charAt(0)) + model.getName().substring(1);
                                data.put(Contract.CarsEntry.COLUMN_NAME, capName);
                                data.put(Contract.CarsEntry.COLUMN_WEB_NAME, model.getNiceName());
                                data.put(Contract.CarsEntry.COLUMN_MODEL_ID, model.getId());
                                capName = Character.toUpperCase(make.getName().charAt(0)) + make.getName().substring(1);
                                data.put(Contract.CarsEntry.COLUMN_MANUFACTURER, capName);
                                data.put(Contract.CarsEntry.COLUMN_WEB_MANUFACTURER, make.getNiceName());
                                data.put(Contract.CarsEntry.COLUMN_YEAR, model.getYears().get(0).getYear());
                                values.add(data);
                            }
                        }

                        if (values.size() > 0) {
                            ContentValues[] cvArray = new ContentValues[values.size()];
                            values.toArray(cvArray);
                            getContentResolver().bulkInsert(Contract.CarsEntry.CONTENT_URI, cvArray);
                        }

                        if (BuildConfig.DEBUG) Log.d(TAG, "Rows inserted " + values.size() + " " + Thread.currentThread());

                        return values.size();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer result) {
                        if (result > 0)
                            getSupportLoaderManager().restartLoader(MAKERS_LIST_LOADER, null, DashBoardActivity.this);
                    }
                });

    }

    private void downloadStylesListData() {

        mLoadingPanel.setVisibility(View.VISIBLE);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork == null) {
            mLoadingPanel.setVisibility(View.GONE);
            Snackbar.make(mLoadingPanel, R.string.snackbar_no_internet_initial, Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbar_action_retry), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            downloadCarListData();
                        }
                    })
                    .show();
            return;
        }

        final String maker = mMakersSpinnerAdapter.getCursor().getString(Contract.CarsEntry.MAKERS_QUERY_WEB_MANUFACTURERS_COLNUM);
        final String model = mModelsSpinnerAdapter.getCursor().getString(Contract.ModelsListQuery.COLNUM_WEB_NAME);

        Observable<Model> mStylesListAPIcall = mAPIService.getStylesList(maker, model);

        mStylesListSubscription = mStylesListAPIcall
                .subscribeOn(Schedulers.newThread())
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d(TAG, "onError: " + throwable.getMessage());
                    }
                })
                .map(new Func1<Model, Integer>() {
                    @Override
                    public Integer call(Model result) {

                        List<ContentValues> values = new ArrayList<ContentValues>();
                        List<Year> years = result.getYears();

                        for (int i = 0; i < years.size(); i++) {
                            Year year = years.get(i);

                            for(Style style: year.getStyles()){
                                ContentValues data = new ContentValues();
                                data.put(Contract.StylesEntry.COLUMN_STYLE_ID, style.getId());
                                data.put(Contract.StylesEntry.COLUMN_MAKER, maker);
                                data.put(Contract.StylesEntry.COLUMN_MODEL, model);
                                data.put(Contract.StylesEntry.COLUMN_YEAR, year.getYear());
                                data.put(Contract.StylesEntry.COLUMN_NAME, style.getName());
                                data.put(Contract.StylesEntry.COLUMN_TYPE, style.getTrim());
                                data.put(Contract.StylesEntry.COLUMN_SUBMODEL, style.getSubmodel().getNiceName());

                                values.add(data);
                            }
                        }

                        if (values.size() > 0) {
                            ContentValues[] cvArray = new ContentValues[values.size()];
                            values.toArray(cvArray);
                            getContentResolver().bulkInsert(Contract.StylesEntry.CONTENT_URI, cvArray);
                        }

                        Log.d(TAG, "Rows inserted " + values.size() + " " + Thread.currentThread());

                        return values.size();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mLoadingPanel.setVisibility(View.GONE);
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer result) {
                        mLoadingPanel.setVisibility(View.GONE);

                        if (result > 0) {
                            Bundle params = new Bundle();
                            params.putString(STYLES_MAKER_PARAM, maker);
                            params.putString(STYLES_MODEL_PARAM, model);
                            getSupportLoaderManager().restartLoader(STYLES_LIST_LOADER, params, DashBoardActivity.this);
                        }
                    }
                });

    }


    public void updateStylesList(View view){

        Cursor makerCursor = mMakersSpinnerAdapter.getCursor();
        Cursor modelCursor =  mModelsSpinnerAdapter.getCursor();
        if (makerCursor != null && modelCursor != null) {
            String maker = makerCursor.getString(Contract.CarsEntry.MAKERS_QUERY_WEB_MANUFACTURERS_COLNUM);
            String model = modelCursor.getString(Contract.ModelsListQuery.COLNUM_WEB_NAME);

            Bundle params = new Bundle();
            params.putString(STYLES_MAKER_PARAM, maker);
            params.putString(STYLES_MODEL_PARAM, model);

            getSupportLoaderManager().restartLoader(STYLES_LIST_LOADER, params, DashBoardActivity.this);
        }
    }
}
