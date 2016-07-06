package com.texocoyotl.ptedmundscars;

import android.app.Application;

import com.texocoyotl.ptedmundscars.dagger.AppModule;
import com.texocoyotl.ptedmundscars.dagger.DaggerRetrofitComponent;
import com.texocoyotl.ptedmundscars.dagger.RetrofitComponent;
import com.texocoyotl.ptedmundscars.dagger.RetrofitModule;

public class App extends Application {

    private RetrofitComponent mRetroFitComponent;
    private RetrofitComponent mRetroFitImagesComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetroFitComponent = DaggerRetrofitComponent.builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule(BuildConfig.BASE_API_URL))
                .build();

        mRetroFitImagesComponent = DaggerRetrofitComponent.builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule(BuildConfig.BASE_IMAGES_API_URL))
                .build();

    }

    public RetrofitComponent getRetroFitComponent() {
        return mRetroFitComponent;
    }
    public RetrofitComponent getRetroFitImagesComponent() {
        return mRetroFitImagesComponent;
    }
}