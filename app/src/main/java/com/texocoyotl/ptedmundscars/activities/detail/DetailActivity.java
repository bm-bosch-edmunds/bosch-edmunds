package com.texocoyotl.ptedmundscars.activities.detail;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.texocoyotl.ptedmundscars.App;
import com.texocoyotl.ptedmundscars.R;
import com.texocoyotl.ptedmundscars.activities.dashboard.DashBoardActivity;
import com.texocoyotl.ptedmundscars.activities.gallery.GalleryActivity;
import com.texocoyotl.ptedmundscars.retrofit.APIService;
import com.texocoyotl.ptedmundscars.api_pojos.Categories;
import com.texocoyotl.ptedmundscars.api_pojos.Engine;
import com.texocoyotl.ptedmundscars.api_pojos.MPG;
import com.texocoyotl.ptedmundscars.api_pojos.Style;
import com.texocoyotl.ptedmundscars.api_pojos.Transmission;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity {

    public static final String STYLE_ID_KEY = "STYLE_ID_KEY";
    private static final String TAG = "DetailTAG_";
    private Subscription mStyleDetailSubscription;
    private FloatingActionButton fab;
    private String mStyleId;

    @Inject
    APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((App) getApplication()).getRetroFitComponent().inject(this);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        if(savedInstanceState == null || !savedInstanceState.containsKey(STYLE_ID_KEY))
            mStyleId = getIntent().getStringExtra(DashBoardActivity.STYLE_ID_PARAM);
        else
            mStyleId = savedInstanceState.getString(STYLE_ID_KEY);


        if (mStyleId != null) {
            downloadDetail();

            if (fab != null)
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(DetailActivity.this, GalleryActivity.class);
                        i.putExtra(STYLE_ID_KEY, mStyleId);
                        startActivity(i);
                    }
                });
        }
    }

    @Override
    public void onDestroy() {
        if (mStyleDetailSubscription != null)
            mStyleDetailSubscription.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(STYLE_ID_KEY, mStyleId);
        super.onSaveInstanceState(savedInstanceState);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public Intent getParentActivityIntent() {
        return super.getParentActivityIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    private void downloadDetail() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork == null) {
            Snackbar.make(null, getString(R.string.snackbar_no_internet_initial), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbar_action_retry), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            downloadDetail();
                        }
                    })
                    .show();
            return;
        }

        Observable<Style> mStyleDetailAPIcall = mAPIService.getStyleDetail(mStyleId);

        mStyleDetailSubscription = mStyleDetailAPIcall
                .subscribeOn(Schedulers.newThread())
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d(TAG, "onError: " + throwable.getMessage());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Style>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Style style) {
                        if (style != null){
                            setTitle(style.getName());

                            TextView market = (TextView) findViewById(R.id.detail_categories_market);
                            TextView catSize = (TextView) findViewById(R.id.detail_categories_size);
                            TextView catStyle = (TextView) findViewById(R.id.detail_categories_style);
                            TextView doors = (TextView) findViewById(R.id.detail_doors);
                            TextView transmission = (TextView) findViewById(R.id.detail_transmission);
                            TextView speeds = (TextView) findViewById(R.id.detail_num_speeds);

                            TextView engineName = (TextView) findViewById(R.id.detail_engine_name);
                            TextView engineType = (TextView) findViewById(R.id.detail_engine_type);
                            TextView cylinders = (TextView) findViewById(R.id.detail_engine_cylinders);
                            TextView engineSize = (TextView) findViewById(R.id.detail_engine_size);
                            TextView horsePower = (TextView) findViewById(R.id.detail_engine_horse_power);

                            TextView mpgHighway = (TextView) findViewById(R.id.detail_mpg_highway);
                            TextView mpgCity = (TextView) findViewById(R.id.detail_mpg_city);

                            Categories cat = style.getCategories();
                            if (cat != null) {
                                market.setText(cat.getMarket());
                                catSize.setText(cat.getVehicleSize());
                                catStyle.setText(cat.getVehicleStyle());
                            }
                            doors.setText(style.getNumOfDoors());
                            Transmission trans = style.getTransmission();
                            if (trans != null){
                                transmission.setText(trans.getTransmissionType());
                                speeds.setText(trans.getNumberOfSpeeds());
                            }

                            Engine engine = style.getEngine();
                            if (engine != null){
                                engineName.setText(engine.getName());
                                engineType.setText(engine.getType());
                                cylinders.setText(engine.getCylinder().toString());
                                engineSize.setText(engine.getSize().toString());
                                horsePower.setText(engine.getHorsepower().toString());
                            }

                            MPG mpg = style.getMPG();
                            if (mpg != null){
                                mpgHighway.setText(mpg.getHighway().toString());
                                mpgCity.setText(mpg.getCity().toString());
                            }


                        }
                    }
                });


    }

}
