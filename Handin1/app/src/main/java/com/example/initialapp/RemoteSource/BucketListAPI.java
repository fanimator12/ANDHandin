package com.example.initialapp.RemoteSource;

import com.example.initialapp.RemoteSource.WebAPI.Model.Auth;
import com.example.initialapp.RemoteSource.WebAPI.Model.Bucketlist;
import com.example.initialapp.RemoteSource.WebAPI.Model.Item;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BucketListAPI {

    @POST("/bucketlist/{id}/item")
    Call<Item> postBucketlistItem(@Path("id") String name);

    @GET("/bucketlist")
    Call<Bucketlist> getBucketlist(@Body String title);

    @GET("/bucketlist/{id}")
    Call<Bucketlist> getBucketlistItem(@Path("id") Item item);

    @POST("/auth/register")
    Call<Auth> postRegister(@Header("Authorization")String auth);

    @POST("/auth/login")
    Call<Auth> postLogin(@Header ("Authorization")String auth);
 }
