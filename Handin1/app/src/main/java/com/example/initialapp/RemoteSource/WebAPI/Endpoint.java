package com.example.initialapp.RemoteSource.WebAPI;

import com.example.initialapp.RemoteSource.WebAPI.Model.Bucketlist;
import com.example.initialapp.RemoteSource.WebAPI.Model.Item;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Endpoint {

    @Headers("application/json")
    @POST("/bucketlist/{id}/item")
    Call<Item> postBucketlistItem(@Body Item name);

    @Headers("application/json")
    @GET("/bucketlist")
    Call<Bucketlist> getBucketlist(@Body Bucketlist bucketlist);
 }
