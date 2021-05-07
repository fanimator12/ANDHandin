package com.example.initialapp.RemoteSource.ServiceGenerator;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder;

    public static Retrofit.Builder getInstance(){
        if(retrofitBuilder == null)
        {
            retrofitBuilder = new Retrofit.Builder()
                    .baseUrl("http://bucketlist.org/api/")
                    .addConverterFactory(GsonConverterFactory.create());
        }
        return retrofitBuilder;
    }
}
