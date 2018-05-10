package com.sample.realmlivedataretrofitdagger.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sample.realmlivedataretrofitdagger.R;
import com.sample.realmlivedataretrofitdagger.activities.DetailActivity;
import com.sample.realmlivedataretrofitdagger.adapters.HeadlineAdapter;
import com.sample.realmlivedataretrofitdagger.databinding.HeadlineFragmentBinding;
import com.sample.realmlivedataretrofitdagger.dataproviders.entities.HeadlineEntity;
import com.sample.realmlivedataretrofitdagger.dataproviders.utils.Resource;
import com.sample.realmlivedataretrofitdagger.dataproviders.utils.Status;
import com.sample.realmlivedataretrofitdagger.interfaces.HeadlineListCallback;
import com.sample.realmlivedataretrofitdagger.viewmodels.HeadlineViewModel;

import java.util.List;

public class HeadlineFragment extends BaseFragment<HeadlineViewModel, HeadlineFragmentBinding> implements HeadlineListCallback {


    public static HeadlineFragment newInstance() {
        Bundle args = new Bundle();
        HeadlineFragment fragment = new HeadlineFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Class<HeadlineViewModel> getViewModel() {
        return HeadlineViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.headline_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        dataBinding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        dataBinding.recyclerView.setAdapter(new HeadlineAdapter(getContext(),this));
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel.getHeadlines().observe(this,this::onHeroesResult);
    }
    private void onHeroesResult(Resource<List<HeadlineEntity>> resource){
        if (resource != null) {

            String message=resource.status.toString()+"dataSize["+(resource.data !=null ? resource.data.size():"null")+"]";

            if (resource.status == Status.SUCCESS) {
                setData(resource);
                Log.d("Resource",message);
//                hideRefreshing();
            } else if (resource.status == Status.ERROR) {
                Toast.makeText(getContext(), "Failed to download heroes, please try again", Toast.LENGTH_SHORT).show();
                setData(resource);
                Log.d("Resource",message);
            } else if (resource.status == Status.LOADING) {
                setData(resource);
            }
        }else {
            Toast.makeText(getContext(), "Resource is null", Toast.LENGTH_SHORT).show();
        }
    }


    private void setData(Resource<List<HeadlineEntity>> resource){
        if (resource.data != null) {
            dataBinding.setResource(resource);
        }
    }

    @Override
    public void onMovieClicked(HeadlineEntity headlineEntity, View sharedView) {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(getActivity(), sharedView, getString(R.string.shared_image));
        startActivity(DetailActivity.newIntent(getActivity(), headlineEntity.getId()), options.toBundle());
    }
}
