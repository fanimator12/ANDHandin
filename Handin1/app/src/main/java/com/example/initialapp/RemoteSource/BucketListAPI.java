package com.example.initialapp.RemoteSource;

import com.example.initialapp.RemoteSource.WebAPI.Model.Bucketlist;
import com.example.initialapp.RemoteSource.WebAPI.Model.Item;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BucketListAPI {

    @Headers("application/json")
    @POST("/bucketlist/{id}/item")
    Call<Item> postBucketlistItem(@Path("id") Item name);

    @Headers("application/json")
    @GET("/bucketlist")
    Call<Bucketlist> getBucketlist(@Body Bucketlist bucketlist);

    @Headers("application/json")
    @GET("/bucketlist/{id}")
    Call<Bucketlist> getBucketlistItem(@Path("id") Item name);
 }
