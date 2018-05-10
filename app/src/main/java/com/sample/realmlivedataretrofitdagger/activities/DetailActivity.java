package com.sample.realmlivedataretrofitdagger.activities;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sample.realmlivedataretrofitdagger.R;
import com.sample.realmlivedataretrofitdagger.databinding.ActivityDetailBinding;
import com.sample.realmlivedataretrofitdagger.viewmodels.DetailViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class DetailActivity extends AppCompatActivity implements LifecycleRegistryOwner{
    private static final String KEY_MOVIE_ID = "key_movie_id";

    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    ActivityDetailBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    DetailViewModel detailViewModel;

    public static Intent newIntent(Context context, int movieId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(KEY_MOVIE_ID, movieId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_detail);

        detailViewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel.class);

        int headlineId = getIntent().getIntExtra(KEY_MOVIE_ID, 0);

        detailViewModel.getHeadline(headlineId).observe(this,headlineEntity -> {
            Log.d("Id","Id");
            binding.setHeadline(headlineEntity);
        });


    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }
}
