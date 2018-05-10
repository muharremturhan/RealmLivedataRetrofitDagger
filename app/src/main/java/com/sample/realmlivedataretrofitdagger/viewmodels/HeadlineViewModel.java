package com.sample.realmlivedataretrofitdagger.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.sample.realmlivedataretrofitdagger.dataproviders.entities.HeadlineEntity;
import com.sample.realmlivedataretrofitdagger.dataproviders.utils.Resource;
import com.sample.realmlivedataretrofitdagger.repositories.HeadlineRepository;

import java.util.List;

import javax.inject.Inject;


public class HeadlineViewModel extends ViewModel {

    private final LiveData<Resource<List<HeadlineEntity>>> popularMovies;

    @Inject
    public HeadlineViewModel(HeadlineRepository headlineRepository) {
        popularMovies = headlineRepository.loadHeadline();
    }

    public LiveData<Resource<List<HeadlineEntity>>> getHeadlines() {
        return popularMovies;
    }
}
