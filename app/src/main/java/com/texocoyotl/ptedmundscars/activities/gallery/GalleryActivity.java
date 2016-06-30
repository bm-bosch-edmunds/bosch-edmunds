package com.texocoyotl.ptedmundscars.activities.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.texocoyotl.ptedmundscars.BuildConfig;
import com.texocoyotl.ptedmundscars.R;
import com.texocoyotl.ptedmundscars.activities.detail.DetailActivity;
import com.texocoyotl.ptedmundscars.retrofit.APIService;
import com.texocoyotl.ptedmundscars.api_pojos.Gallery;
import com.texocoyotl.ptedmundscars.retrofit.RetrofitHelper;

import java.util.Collections;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryTAG_";
    private String mStyleId;
    private Subscription mGallerySubscription;
    private ImageView[] imgs;
    private GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        grid = (GridLayout) findViewById(R.id.gallery_grid);


        mStyleId = getIntent().getStringExtra(DetailActivity.STYLE_ID_KEY);
        if (mStyleId != null) {
            downloadGallery();
        }
    }


    @Override
    public void onDestroy() {
        if (mGallerySubscription != null)
            mGallerySubscription.unsubscribe();
        super.onDestroy();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public Intent getParentActivityIntent() {
        return super.getParentActivityIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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

        APIService apiService = RetrofitHelper.getAPIService(BuildConfig.BASE_IMAGES_API_URL);
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

                            for (int i = 0; i < galleries.size(); i++) {
                                Gallery gallery = galleries.get(i);
                                List<String> photos = gallery.getPhotoSrcs();
                                Collections.sort(photos);
                                String url = photos.size() > 5 ? photos.get(5) : "";

                                Log.d(TAG, "onNext: Loading url " + url);

                                GalleryActivity self = GalleryActivity.this;
                                DisplayMetrics metrics = new DisplayMetrics();
                                getWindowManager().getDefaultDisplay().getMetrics(metrics);

                                int width = metrics.widthPixels;
                                int height = metrics.heightPixels;

                                ImageView img= new ImageView(self);
//                                GridLayout.LayoutParams params = new GridLayout.LayoutParams(width, height/2);
//                                img.setLayoutParams(params);

                                grid.addView(img);

                                Picasso.with(self)
                                        .load(BuildConfig.BASE_IMAGES_URL + url)
                                        .resize(grid.getWidth() / 2, (int) (grid.getWidth() * 0.75 / 2))
                                        .centerCrop()
                                        .into(img);

                            }


                        }
                    }
                });


    }

}