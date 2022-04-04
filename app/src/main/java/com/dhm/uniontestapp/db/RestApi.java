package com.dhm.uniontestapp.db;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {

    private static final String TAG = "RestApi";

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://621f4674311a70591407189f.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static RewardRoute sendRequestGet(){
        RewardRoute userService = null;
        try{
            userService = getRetrofit().create(RewardRoute.class);
        }catch (Exception e){
            Log.e(TAG, "sendRequestGet: ", e);
        }
        return userService;
    }

}

