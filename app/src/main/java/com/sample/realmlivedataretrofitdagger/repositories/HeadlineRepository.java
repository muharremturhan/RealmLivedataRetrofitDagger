package com.sample.realmlivedataretrofitdagger.repositories;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.sample.realmlivedataretrofitdagger.dataproviders.entities.HeadlineEntity;
import com.sample.realmlivedataretrofitdagger.dataproviders.local.HeadlineDao;
import com.sample.realmlivedataretrofitdagger.dataproviders.remote.ApiService;
import com.sample.realmlivedataretrofitdagger.dataproviders.utils.NetworkBoundResource;
import com.sample.realmlivedataretrofitdagger.dataproviders.utils.Resource;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class HeadlineRepository {
    private final HeadlineDao headlineDao;
    private final ApiService apiService;

    @Inject
    public HeadlineRepository(HeadlineDao headlineDao, ApiService apiService) {
        this.apiService = apiService;
        this.headlineDao = headlineDao;
    }
    public LiveData<Resource<List<HeadlineEntity>>> loadHeadline() {
        return new NetworkBoundResource<List<HeadlineEntity>, List<HeadlineEntity>>() {

            @Override
            protected void saveCallResult(@NonNull List<HeadlineEntity> item) {
                headlineDao.saveHeadlineData(item);
            }

            @NonNull
            @Override
            protected LiveData<List<HeadlineEntity>> loadFromDb() {
                return headlineDao.loadManset();
            }

            @NonNull
            @Override
            protected Call<List<HeadlineEntity>> createCall() {
                return apiService.getUsers();
            }
        }.getAsLiveData();
    }


    public LiveData<HeadlineEntity> getHeadline(int id){
        return headlineDao.getHeadline(id);
    }

}
