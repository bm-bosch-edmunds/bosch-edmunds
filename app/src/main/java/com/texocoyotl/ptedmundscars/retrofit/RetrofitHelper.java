package com.texocoyotl.ptedmundscars.retrofit;

import com.texocoyotl.ptedmundscars.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.schedulers.Schedulers;

public class RetrofitHelper {

    public static APIService getAPIService(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(APIService.class);
    }
}
