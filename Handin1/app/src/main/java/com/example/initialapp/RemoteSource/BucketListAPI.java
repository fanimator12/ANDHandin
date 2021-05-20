package com.example.initialapp.RemoteSource;

import com.example.initialapp.RemoteSource.WebAPI.Model.Auth;
import com.example.initialapp.RemoteSource.WebAPI.Model.Bucketlist;
import com.example.initialapp.RemoteSource.WebAPI.Model.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BucketListAPI {

    @POST("/bucketlist")
    Call<Bucketlist> postBucketlist(@Header("Authorization") String auth, @Body Bucketlist title);

    @GET("/bucketlist")
    Call<List<Bucketlist>> getBucketlist(@Header("Authorization") String auth);

    @POST("/auth/login")
    Call<Token> postLogin(@Body Auth auth);
 }
