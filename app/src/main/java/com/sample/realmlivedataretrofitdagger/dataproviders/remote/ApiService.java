package com.sample.realmlivedataretrofitdagger.dataproviders.remote;


import com.sample.realmlivedataretrofitdagger.dataproviders.entities.HeadlineEntity;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {


    @GET("/users/{user}")
    Call<HeadlineEntity> getUser(@Path("user") String userId);

    @GET("users")
    Call<List<HeadlineEntity>> getUsers();
}
