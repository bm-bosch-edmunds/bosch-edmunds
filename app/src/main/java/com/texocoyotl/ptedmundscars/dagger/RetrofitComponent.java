package com.texocoyotl.ptedmundscars.dagger;


import android.support.v7.app.AppCompatActivity;

import com.texocoyotl.ptedmundscars.activities.dashboard.DashBoardActivity;
import com.texocoyotl.ptedmundscars.activities.detail.DetailActivity;
import com.texocoyotl.ptedmundscars.activities.gallery.GalleryActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class})
public interface RetrofitComponent {
    void inject(DashBoardActivity activity);
    void inject(DetailActivity activity);
    void inject(GalleryActivity activity);
}
