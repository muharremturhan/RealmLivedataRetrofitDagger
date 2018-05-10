package com.sample.realmlivedataretrofitdagger;

import android.app.Activity;
import android.app.Application;

import com.sample.realmlivedataretrofitdagger.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.realm.Realm;

public class App extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        initializeComponent();
    }
    private void initializeComponent() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingInjector;
    }
}
