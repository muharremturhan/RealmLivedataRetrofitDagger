package com.sample.realmlivedataretrofitdagger.dataproviders.local;


import com.sample.realmlivedataretrofitdagger.dataproviders.entities.HeadlineEntity;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmModel;

public abstract class BaseDao<T extends RealmModel> {

    protected Realm db;

    public BaseDao(Realm db) {
        this.db = db;
    }

    public T copyOrUpdate(T entity) {

        if(db.isInTransaction()) {
            entity = db.copyToRealmOrUpdate(entity);

        } else {
            try {
                db.beginTransaction();
                entity = db.copyToRealmOrUpdate(entity);
                db.commitTransaction();
            } catch (Exception e) {
                db.cancelTransaction();
                throw e;
            }
        }

        return entity;
    }


    public void saveHeadlineData(List<HeadlineEntity> headlineEntities){
        Realm.getDefaultInstance().executeTransaction(realm -> {
            realm.insertOrUpdate(headlineEntities);
        });

    }
}
