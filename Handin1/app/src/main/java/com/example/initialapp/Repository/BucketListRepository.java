package com.example.initialapp.Repository;

import android.app.Application;

import com.example.initialapp.RemoteSource.BucketListRemoteSource.BucketListRemoteDataSource;
import com.example.initialapp.RemoteSource.BucketListRemoteSource.IBucketListRemoteDataSource;

public class BucketListRepository implements IBucketListRepository {

    private IBucketListRemoteDataSource bucketListRemoteDataSource;
    //TODO add model here

    public BucketListRepository(Application application) {
       // bucketListRemoteDataSource = new BucketListRemoteDataSource();
    }

    @Override
    public void getIdea() {
        bucketListRemoteDataSource.getIdea();
    }
}
