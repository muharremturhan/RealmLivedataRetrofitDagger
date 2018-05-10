package com.sample.realmlivedataretrofitdagger.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.sample.realmlivedataretrofitdagger.di.ViewModelKey;
import com.sample.realmlivedataretrofitdagger.viewmodels.CustomViewModelFactory;
import com.sample.realmlivedataretrofitdagger.viewmodels.DetailViewModel;
import com.sample.realmlivedataretrofitdagger.viewmodels.HeadlineViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HeadlineViewModel.class)
    abstract ViewModel bindsHeadlineViewModel(HeadlineViewModel headlineViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel.class)
    abstract ViewModel bindsHeadlineDetailViewModel(DetailViewModel detailViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(CustomViewModelFactory movieViewModelFactory);

}
