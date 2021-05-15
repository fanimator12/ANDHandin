package com.example.initialapp.RemoteSource.ServiceGenerator;

import android.util.Base64;

import com.example.initialapp.RemoteSource.BucketListGenerator.Endpoint.BucketListAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder;

    public static Retrofit.Builder getInstance(){
        if(retrofitBuilder == null)
        {
            retrofitBuilder = new Retrofit.Builder()
                    .baseUrl("http://bucketlist.org/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient);
        }
        return retrofitBuilder;
    }

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build();

    private static Retrofit retrofit = retrofitBuilder.build();

    private static BucketListAPI bucketListAPI = retrofit.create(BucketListAPI.class);

    public static BucketListAPI getBucketListAPI() {
        return bucketListAPI;
    }

    public static String getAuthHeader(String user,String password){
        String base = user + ":" + password;
        String auth = "Basic " + Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);
        return  auth;
    }

}
