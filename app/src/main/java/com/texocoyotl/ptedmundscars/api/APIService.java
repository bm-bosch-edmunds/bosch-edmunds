package com.texocoyotl.ptedmundscars.api;

import com.texocoyotl.ptedmundscars.BuildConfig;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


public interface APIService {
    @GET("makes?state=new&year=2016&view=basic&fmt=json&api_key=" + BuildConfig.API_KEY)
    Observable<CarsResult> getCarsList();

    @GET("{maker}/{model}?state=new&view=basic&fmt=json&api_key=" + BuildConfig.API_KEY)
    Observable<Model> getStylesList(@Path("maker") String maker, @Path("model") String model);

    @GET("styles/{styleId}?view=full&fmt=json&api_key=" + BuildConfig.API_KEY)
    Observable<Style> getStyleDetail(@Path("styleId") String styleId);
}
