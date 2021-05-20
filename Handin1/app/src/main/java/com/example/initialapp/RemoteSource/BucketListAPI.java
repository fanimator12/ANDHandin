package com.example.initialapp.RemoteSource;

import com.example.initialapp.RemoteSource.WebAPI.Model.Auth;
import com.example.initialapp.RemoteSource.WebAPI.Model.Bucketlist;
import com.example.initialapp.RemoteSource.WebAPI.Model.Item;
import com.example.initialapp.RemoteSource.WebAPI.Model.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BucketListAPI {

    @POST("/bucketlist")
    Call<Bucketlist> postBucketlist(@Header("Authorization") String auth, @Body Bucketlist title);

    @GET("/bucketlist")
    Call<List<Bucketlist>> getBucketlist(@Header("Authorization") String auth);

    @GET("/bucketlist/{id}")
    Call<Bucketlist> getBucketlistItem(@Header("Authorization") String auth, @Path("id") Item item);

//    @POST("/auth/register")
//    Call<Auth> postRegister(@Header("Authorization")String auth);

    @POST("/auth/login")
    Call<Token> postLogin(@Body Auth auth);
 }
