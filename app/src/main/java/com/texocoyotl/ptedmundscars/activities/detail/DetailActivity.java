package com.texocoyotl.ptedmundscars.activities.detail;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.texocoyotl.ptedmundscars.BuildConfig;
import com.texocoyotl.ptedmundscars.R;
import com.texocoyotl.ptedmundscars.activities.dashboard.DashBoardActivity;
import com.texocoyotl.ptedmundscars.api.APIService;
import com.texocoyotl.ptedmundscars.api.Categories;
import com.texocoyotl.ptedmundscars.api.Engine;
import com.texocoyotl.ptedmundscars.api.MPG;
import com.texocoyotl.ptedmundscars.api.Style;
import com.texocoyotl.ptedmundscars.api.Transmission;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailTAG_";
    private Subscription mStyleDetailSubscription;
    private FloatingActionButton fab;
    private String mStyleId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        mStyleId = getIntent().getStringExtra(DashBoardActivity.STYLE_ID_PARAM);
        if (mStyleId != null) {
            downloadDetail(mStyleId);

            if (fab != null)
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DetailActivity.this, mStyleId, Toast.LENGTH_SHORT).show();
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

    private void downloadDetail(final String styleId) {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork == null) {
            Snackbar.make(null, getString(R.string.snackbar_no_internet_initial), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbar_action_retry), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            downloadDetail(styleId);
                        }
                    })
                    .show();
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Observable<Style> mStyleDetailAPIcall = apiService.getStyleDetail(styleId);

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
                                cylinders.setText(engine.getCylinder());
                                engineSize.setText(engine.getSize().toString());
                                horsePower.setText(engine.getHorsepower());
                            }

                            MPG mpg = style.getMPG();
                            if (mpg != null){
                                mpgHighway.setText(mpg.getHighway());
                                mpgCity.setText(mpg.getCity());
                            }


                        }
                    }
                });


    }

}
