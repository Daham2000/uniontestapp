package com.dhm.uniontestapp;

import java.time.OffsetDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface RewardModel {

    @GET("rewards/")
    Call<List<Reward>> getAllUsers();

}


