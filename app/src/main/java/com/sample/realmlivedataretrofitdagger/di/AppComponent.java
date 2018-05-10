package com.sample.realmlivedataretrofitdagger.di;

import android.app.Application;

import com.sample.realmlivedataretrofitdagger.App;
import com.sample.realmlivedataretrofitdagger.modules.ActivityBuilderModule;
import com.sample.realmlivedataretrofitdagger.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by mertsimsek on 20/05/2017.
 */
@Singleton
@Component(modules = {AppModule.class, AndroidInjectionModule.class, ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(App App);
}
