package com.texocoyotl.ptedmundscars.views.activities.gallery;

import android.content.Context;

import java.util.List;

public interface GalleryView {

    Context getContext();
    void showImages(List<String> urls);

}
