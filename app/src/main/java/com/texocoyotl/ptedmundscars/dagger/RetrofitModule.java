package com.texocoyotl.ptedmundscars.dagger;

import android.app.Application;

import com.texocoyotl.ptedmundscars.retrofit.APIService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.schedulers.Schedulers;

@Module
public class RetrofitModule {

    private String mUrl;

    public RetrofitModule(String url){
        this.mUrl = url;
    }

    @Provides
    @Singleton
    public APIService providesAPIService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(APIService.class);
    }


}
