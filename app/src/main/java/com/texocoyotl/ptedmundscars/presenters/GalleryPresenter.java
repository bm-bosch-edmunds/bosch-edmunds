package com.texocoyotl.ptedmundscars.presenters;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.texocoyotl.ptedmundscars.App;
import com.texocoyotl.ptedmundscars.api_pojos.Gallery;
import com.texocoyotl.ptedmundscars.retrofit.APIService;
import com.texocoyotl.ptedmundscars.views.activities.gallery.GalleryActivity;
import com.texocoyotl.ptedmundscars.views.activities.gallery.GalleryView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GalleryPresenter implements BasePresenter<GalleryView>{

    private static final String TAG = "GalleryTAG_";
    private GalleryView mView;
    private Subscription mSubscription;
    private String mStyleId;

    @Inject
    APIService mAPIService;

    @Override
    public void attachView(GalleryView view) {
        mView = view;
        ((App) mView.getContext().getApplicationContext()).getRetroFitImagesComponent().inject(this);
    }

    @Override
    public void detachView() {
        mView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public boolean downloadData(String mStyleId) {

        ConnectivityManager cm = (ConnectivityManager) mView.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork == null) return false;

        Observable<List<Gallery>> mGalleryAPIcall = mAPIService.getGallery(mStyleId);

        mSubscription = mGalleryAPIcall
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

                        List<String> urls = new ArrayList<String>();
                        if (galleries != null) {

                            for (int i = 0; i < galleries.size(); i++) {
                                Gallery gallery = galleries.get(i);
                                List<String> photos = gallery.getPhotoSrcs();
                                Collections.sort(photos);
                                String url = photos.size() > 1 ? photos.get(photos.size() / 2) : photos.get(0);

                                if (url != null) urls.add(url);

                            }

                        }

                        mView.showImages(urls);
                    }
                });

        return true;
    }
}
