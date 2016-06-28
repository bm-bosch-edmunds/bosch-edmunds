package com.texocoyotl.ptedmundscars.api;

import retrofit2.http.GET;
import rx.Observable;


public interface APIService {
    @GET("makes?state=new&year=2016&view=basic&fmt=json&api_key=5eyw33g6h9rafn2x2gge5hmg")
    Observable<CarsResult> getCarsList();
}
