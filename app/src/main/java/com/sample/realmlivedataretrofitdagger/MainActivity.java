package com.sample.realmlivedataretrofitdagger;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sample.realmlivedataretrofitdagger.activities.BaseActivity;
import com.sample.realmlivedataretrofitdagger.databinding.ActivityMainBinding;
import com.sample.realmlivedataretrofitdagger.fragments.HeadlineFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private static final String TAG="MainFragment";

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FragmentManager fragmentManager=getSupportFragmentManager();
        HeadlineFragment fragment=(HeadlineFragment) fragmentManager.findFragmentByTag(TAG);

        if(fragment==null){
            fragment=HeadlineFragment.newInstance();
        }
        addFragmentToActivity(fragmentManager,fragment,dataBinding.rootContainer.getId(),TAG);
        
//        dataBinding.viewPager.setAdapter(new MoviesPagerAdapter(getSupportFragmentManager()));
//        dataBinding.tabs.setupWithViewPager(dataBinding.viewPager);
//        dataBinding.viewPager.setOffscreenPageLimit(3);
    }
}
