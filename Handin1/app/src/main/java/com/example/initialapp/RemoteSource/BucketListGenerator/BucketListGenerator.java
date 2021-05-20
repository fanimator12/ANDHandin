package com.example.initialapp.RemoteSource.BucketListGenerator;

import com.example.initialapp.RemoteSource.WebAPI.API.BucketlistApi;
import com.example.initialapp.RemoteSource.ServiceGenerator.ServiceGenerator;

import retrofit2.Retrofit;

public class BucketListGenerator implements IBucketListGenerator {
    private static BucketlistApi bucketListAPI;
    private Retrofit.Builder baseRetrofitBuilder;

    public BucketListGenerator() {
        baseRetrofitBuilder = ServiceGenerator.getInstance();
    }

    @Override
    public BucketlistApi getGoalAPI() {
        if (bucketListAPI == null) {
            bucketListAPI = baseRetrofitBuilder
                    .build()
                    .create(BucketlistApi.class);
        }
        return bucketListAPI;
    }
}
