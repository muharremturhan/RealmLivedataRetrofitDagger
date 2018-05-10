package com.sample.realmlivedataretrofitdagger.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.sample.realmlivedataretrofitdagger.dataproviders.entities.HeadlineEntity;
import com.sample.realmlivedataretrofitdagger.dataproviders.utils.Resource;
import com.sample.realmlivedataretrofitdagger.repositories.HeadlineRepository;

import javax.inject.Inject;

public class DetailViewModel extends ViewModel {

    private final LiveData<Resource<HeadlineEntity>> movieDetail = new MutableLiveData<>();
    private final HeadlineRepository repository;


    @Inject
    public DetailViewModel(HeadlineRepository repository){
        this.repository=repository;
    }


    public LiveData<HeadlineEntity> getHeadline(int id){
        return repository.getHeadline(id);
    }

}
