package com.example.initialapp.RemoteSource.BucketListGenerator.Endpoint;

import com.example.initialapp.Domain.GoalResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface BucketListAPI {
    //endpoint

    @Headers("Accept: application/json")
    @GET("categories/Usage/goals;label")
    Call<GoalResponse> getGoal(@Header("Authorization") String auth);
}
