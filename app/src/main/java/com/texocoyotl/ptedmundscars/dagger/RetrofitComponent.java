package com.texocoyotl.ptedmundscars.dagger;


import com.texocoyotl.ptedmundscars.presenters.GalleryPresenter;
import com.texocoyotl.ptedmundscars.views.activities.dashboard.DashBoardActivity;
import com.texocoyotl.ptedmundscars.views.activities.detail.DetailActivity;
import com.texocoyotl.ptedmundscars.views.activities.gallery.GalleryActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class})
public interface RetrofitComponent {
    void inject(DashBoardActivity activity);
    void inject(DetailActivity activity);
    void inject(GalleryPresenter presenter);
}
