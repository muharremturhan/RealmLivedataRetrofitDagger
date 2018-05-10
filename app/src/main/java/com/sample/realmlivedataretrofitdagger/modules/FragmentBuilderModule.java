package com.sample.realmlivedataretrofitdagger.modules;

import com.sample.realmlivedataretrofitdagger.fragments.HeadlineFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract HeadlineFragment contributeHeadlineFragment();
}
