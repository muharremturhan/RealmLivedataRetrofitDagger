package com.sample.realmlivedataretrofitdagger.modules;


import com.sample.realmlivedataretrofitdagger.MainActivity;
import com.sample.realmlivedataretrofitdagger.activities.DetailActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract DetailActivity detailActivity();

}
