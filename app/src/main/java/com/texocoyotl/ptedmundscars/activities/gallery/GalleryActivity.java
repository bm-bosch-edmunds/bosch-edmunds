package com.texocoyotl.ptedmundscars.activities.gallery;

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

import com.texocoyotl.ptedmundscars.BuildConfig;
import com.texocoyotl.ptedmundscars.R;
import com.texocoyotl.ptedmundscars.activities.dashboard.DashBoardActivity;
import com.texocoyotl.ptedmundscars.activities.detail.DetailActivity;
import com.texocoyotl.ptedmundscars.api.APIService;
import com.texocoyotl.ptedmundscars.api.Categories;
import com.texocoyotl.ptedmundscars.api.Engine;
import com.texocoyotl.ptedmundscars.api.Gallery;
import com.texocoyotl.ptedmundscars.api.MPG;
import com.texocoyotl.ptedmundscars.api.Style;
import com.texocoyotl.ptedmundscars.api.Transmission;

import java.util.Collections;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryTAG_";
    private String mStyleId;
    private Subscription mGallerySubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mStyleId = getIntent().getStringExtra(DetailActivity.STYLE_ID_KEY);
        if (mStyleId != null) {
            downloadGallery();
        }
    }


    private void downloadGallery() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork == null) {
            Snackbar.make(null, getString(R.string.snackbar_no_internet_initial), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbar_action_retry), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            downloadGallery();
                        }
                    })
                    .show();
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_IMAGES_API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Observable<List<Gallery>> mGalleryAPIcall = apiService.getGallery(mStyleId);

        mGallerySubscription = mGalleryAPIcall
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Gallery>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(List<Gallery> galleries) {
                        if (galleries != null){

                            for (int i = 0; i < galleries.size() && i < 4; i++) {
                                Gallery gallery = galleries.get(i);
                                List<String> photos = gallery.getPhotoSrcs();
                                Collections.sort(photos);
                                String url = photos.size() > 6 ? photos.get(6) : "";



                            }


                        }
                    }
                });


    }

}