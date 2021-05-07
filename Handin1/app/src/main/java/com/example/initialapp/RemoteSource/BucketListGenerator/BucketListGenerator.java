package com.example.initialapp.RemoteSource.BucketListGenerator;

import com.example.initialapp.RemoteSource.BucketListGenerator.Endpoint.BucketListAPI;
import com.example.initialapp.RemoteSource.ServiceGenerator.ServiceGenerator;
import com.example.initialapp.Repository.IBucketListRepository;

import retrofit2.Retrofit;

public class BucketListGenerator implements IBucketListGenerator {
    private static BucketListAPI bucketListAPI;
    private Retrofit.Builder baseRetrofitBuilder;

    public BucketListGenerator() {
        baseRetrofitBuilder = ServiceGenerator.getInstance();
    }

    @Override
    public BucketListAPI getIdeaAPI() {
        if (bucketListAPI == null) {
            bucketListAPI = baseRetrofitBuilder
                    .build()
                    .create(BucketListAPI.class);
        }
        return bucketListAPI;
    }
}