package com.texocoyotl.ptedmundscars.views.activities.gallery;

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
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.texocoyotl.ptedmundscars.App;
import com.texocoyotl.ptedmundscars.BuildConfig;
import com.texocoyotl.ptedmundscars.R;
import com.texocoyotl.ptedmundscars.presenters.GalleryPresenter;
import com.texocoyotl.ptedmundscars.views.activities.detail.DetailActivity;
import com.texocoyotl.ptedmundscars.retrofit.APIService;
import com.texocoyotl.ptedmundscars.api_pojos.Gallery;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GalleryActivity extends AppCompatActivity implements GalleryView{

    private static final String TAG = "GalleryTAG_";
    private String mStyleId;
    private GridLayout grid;
    private GalleryPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new GalleryPresenter();
        presenter.attachView(this);

        grid = (GridLayout) findViewById(R.id.gallery_grid);

        mStyleId = getIntent().getStringExtra(DetailActivity.STYLE_ID_KEY);
        if (mStyleId != null) downloadGallery();
    }

    private void downloadGallery(){
        if (!presenter.downloadData(mStyleId)){
            Snackbar.make(grid, getString(R.string.snackbar_no_internet_initial), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.snackbar_action_retry), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            downloadGallery();
                        }
                    })
                    .show();
        };
    }


    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public Intent getParentActivityIntent() {
        return super.getParentActivityIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showImages(List<String> urls) {

        for(String url : urls){
            ImageView img= new ImageView(this);
            grid.addView(img);

            Picasso.with(this)
                    .load(BuildConfig.BASE_IMAGES_URL + url)
                    .resize(grid.getWidth() / 2, (int) (grid.getWidth() * 0.75 / 2))
                    .centerCrop()
                    .into(img);
        }
    }
}




