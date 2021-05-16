package com.example.initialapp.RemoteSource.BucketListGenerator.Endpoint;

import com.example.initialapp.Domain.GoalResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * This class contains the methods to consume the API
 * using the retrofit framework
 *
 */

public interface BucketListAPI {
    //endpoints

//    @Headers("Accept: application/json")
//    @POST("/auth/signup")
//    Call<GoalResponse> signUp(@Header("Authorization") String auth);
//
////    @Headers("Accept: application/json")
////    @POST("/auth/login")
////    Call<GoalResponse> login(@Header("Authorization") String auth);

    @Headers("Accept: application/json")
    @GET("/auth/logout")
    Call<GoalResponse> logout(@Header("Authorization") String auth);

//    @Headers("Accept: application/json")
//    @POST("/bucketlists")
//    Call<GoalResponse> createBucketlist(@Header("Authorization") String auth, @Header("Create New") Integer bucketlistID);

    @Headers("Accept: application/json")
    @GET("/bucketlists")
    Call<GoalResponse> listAll(@Header("Authorization") String auth, @Query("bucketlists") Integer bucketlistID);

    @Headers("Accept: application/json")
    @GET("bucketlists/{bucketlist_id}")
    Call<GoalResponse> getBucketlist(@Header("Authorization") String auth, @Query("bucketlist") Integer bucketlistID);

//    @Headers("Accept: application/json")
//    @PUT("bucketlists")
//    Call<GoalResponse> updateBucketlist(@Header("Update Bucketlist") Integer bucketlistID);

//    @Headers("Accept: application/json")
//    @DELETE("bucketlists/{bucketlist_id}")
//    Call<GoalResponse> deleteBucketlist(@Header("Delete Bucketlist") Integer bucketlistID);
//
//    @Headers("Accept: application/json")
//    @POST("bucketlists/{bucketlist_id}/items")
//    Call<GoalResponse> createItem(@Header("Create New Item in Bucketlist") Integer bucketlistID);
//
////    @Headers("Accept: application/json")
////    @PUT("bucketlists/{bucketlist_id}/items/{item_id}")
////    Call<GoalResponse> updateItem(@Header("Update Item in Bucketlist") Integer bucketlistID, @Query("item") Integer itemID);
//
//    @Headers("Accept: application/json")
//    @DELETE("bucketlists/{bucketlist_id}/items/{item_id}")
//    Call<GoalResponse> deleteItem(@Header("Delete Item from Bucketlist") Integer bucketlistID, @Query("item") Integer itemID);
}
