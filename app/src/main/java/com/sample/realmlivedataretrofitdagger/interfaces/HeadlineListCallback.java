package com.sample.realmlivedataretrofitdagger.interfaces;

import android.view.View;

import com.sample.realmlivedataretrofitdagger.dataproviders.entities.HeadlineEntity;

public interface HeadlineListCallback {

    void onMovieClicked(HeadlineEntity headlineEntity, View sharedView);

}
