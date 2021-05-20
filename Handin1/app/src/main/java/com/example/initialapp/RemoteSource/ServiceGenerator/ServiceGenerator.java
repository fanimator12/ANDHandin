package com.example.initialapp.RemoteSource.ServiceGenerator;

import android.util.Base64;

import com.example.initialapp.RemoteSource.BucketListAPI;

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

    public static BucketListAPI getBucketListAPI() {
        Retrofit retrofit = getInstance().build();

        BucketListAPI bucketListAPI = retrofit.create(BucketListAPI.class);

        return bucketListAPI;
    }

    public static String getAuthHeader(String user, String password) {
        String base = user + ":" + password;
        String auth = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);
        return auth;
    }
}
