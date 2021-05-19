package com.example.initialapp.RemoteSource.ServiceGenerator;

import android.util.Base64;

import com.example.initialapp.RemoteSource.WebAPI.API.BucketlistApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder;

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build();

    public static Retrofit.Builder getInstance() {
        if (retrofitBuilder == null) {
            retrofitBuilder = new Retrofit.Builder()
                    .baseUrl("https://bucketlist-api1.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient);
        }
        return retrofitBuilder;
    }

    private static Retrofit retrofit = retrofitBuilder.build();

    private static BucketlistApi bucketListAPI = retrofit.create(BucketlistApi.class);

    public static BucketlistApi getBucketListAPI() {
        return bucketListAPI;
    }

    public static String getAuthHeader(String user, String password) {
        String base = user + ":" + password;
        String auth = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);
        return auth;
    }

    public static Integer getBucketListHeader(int bucketlistID) {
        String base = "Bucketlist item:" + bucketlistID;
        return bucketlistID;
    }
}
