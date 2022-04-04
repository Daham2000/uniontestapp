package com.dhm.uniontestapp.db;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface RewardRoute {

    @GET("rewards/")
    Call<List<RewardModel>> getAllUsers();

}


