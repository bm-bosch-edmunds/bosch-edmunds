package com.texocoyotl.ptedmundscars.presenters;

public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();

}
