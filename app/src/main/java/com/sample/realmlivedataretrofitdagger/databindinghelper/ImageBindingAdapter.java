package com.sample.realmlivedataretrofitdagger.databindinghelper;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.sample.realmlivedataretrofitdagger.R;
import com.squareup.picasso.Picasso;


/**
 * Created by mertsimsek on 20/05/2017.
 */

public final class ImageBindingAdapter {

    @BindingAdapter(value = "url")
    public static void loadImageUrl(ImageView view, String url) {
        if (url != null && !url.equals("")){
            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.placeholder)
                    .into(view);
        }

    }

}
