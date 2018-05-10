package com.sample.realmlivedataretrofitdagger.dataproviders.local;

import android.arch.lifecycle.LiveData;

import com.sample.realmlivedataretrofitdagger.dataproviders.entities.HeadlineEntity;
import com.sample.realmlivedataretrofitdagger.dataproviders.utils.RealmLiveData;
import com.sample.realmlivedataretrofitdagger.dataproviders.utils.RealmResultsLiveData;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class HeadlineDao extends BaseDao<HeadlineEntity>{

    public HeadlineDao(Realm db) {
        super(db);
    }

    private RealmQuery<HeadlineEntity> where() {
        return db.where(HeadlineEntity.class);
    }

    public void saveHeadlines(List<HeadlineEntity> headlineEntities){
        saveHeadlineData(headlineEntities);
    }
    public LiveData<List<HeadlineEntity>> loadManset(){
        return  new RealmResultsLiveData<>(where().findAllAsync());
    }


    public LiveData<HeadlineEntity> getHeadline(int id){
        return new RealmLiveData<>(where().equalTo("id",id).findFirstAsync());
    }


    public void deleteManset(){
//      silme işlemi
    }

}
