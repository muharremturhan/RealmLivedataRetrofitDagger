package com.sample.realmlivedataretrofitdagger.databindinghelper;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;


import com.sample.realmlivedataretrofitdagger.adapters.BaseAdapter;
import com.sample.realmlivedataretrofitdagger.dataproviders.utils.Resource;

import java.util.List;

/**
 * Created by mertsimsek on 20/05/2017.
 */

public final class ListBindingAdapter {
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(resource == null || resource.data == null)
            return;

        if(adapter instanceof BaseAdapter){
            ((BaseAdapter)adapter).setData((List) resource.data);
        }
    }
}
