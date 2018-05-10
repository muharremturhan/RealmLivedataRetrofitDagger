package com.sample.realmlivedataretrofitdagger.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.realmlivedataretrofitdagger.databinding.HeadlineListItemBinding;
import com.sample.realmlivedataretrofitdagger.dataproviders.entities.HeadlineEntity;
import com.sample.realmlivedataretrofitdagger.interfaces.HeadlineListCallback;

import java.util.ArrayList;
import java.util.List;

public class HeadlineAdapter extends BaseAdapter<HeadlineAdapter.HeadlineItemViewHolder, HeadlineEntity> {

    private List<HeadlineEntity> movieEntities;
    Context context;
    private final HeadlineListCallback callback;
    public HeadlineAdapter(Context context,HeadlineListCallback callback) {
        movieEntities = new ArrayList<>();
        this.callback=callback;

    }

    @Override
    public void setData(List<HeadlineEntity> movieEntities) {
        this.movieEntities = movieEntities;
        notifyDataSetChanged();
    }

    @Override
    public HeadlineItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        return HeadlineItemViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup,callback);


    }

    @Override
    public void onBindViewHolder(HeadlineItemViewHolder viewHolder, int i) {
        viewHolder.onBind(movieEntities.get(i));
    }

    @Override
    public int getItemCount() {
        return movieEntities.size();
    }
//
    static class HeadlineItemViewHolder extends RecyclerView.ViewHolder {
        public static HeadlineItemViewHolder create(LayoutInflater inflater, ViewGroup parent,HeadlineListCallback callback) {
            HeadlineListItemBinding binding = HeadlineListItemBinding.inflate(inflater, parent, false);

            return new HeadlineItemViewHolder(binding,callback);
        }
        HeadlineListItemBinding binding;

        public HeadlineItemViewHolder(HeadlineListItemBinding binding,HeadlineListCallback callback) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(v -> callback.onMovieClicked(binding.getHeadline(), binding.imageViewCover));
        }

        public void onBind(HeadlineEntity headlineEntity) {
            binding.setHeadline(headlineEntity);
            binding.executePendingBindings();
        }
    }
}
