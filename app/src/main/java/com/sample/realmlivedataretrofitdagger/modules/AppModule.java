package com.sample.realmlivedataretrofitdagger.modules;

import android.app.Application;

import com.sample.realmlivedataretrofitdagger.dataproviders.local.HeadlineDao;
import com.sample.realmlivedataretrofitdagger.dataproviders.local.RealmDb;
import com.sample.realmlivedataretrofitdagger.dataproviders.remote.ApiConstant;
import com.sample.realmlivedataretrofitdagger.dataproviders.remote.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule {


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(ApiConstant.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(ApiConstant.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
//        okHttpClient.addInterceptor(new RequestInterceptor());
        return okHttpClient.build();
    }


    @Provides
    @Singleton
    ApiService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    Realm provideMovieDatabase(Application application) {
        return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    HeadlineDao provideHeadlineDao(Realm headlineDatabase) {
        return new HeadlineDao(headlineDatabase);
    }

}
