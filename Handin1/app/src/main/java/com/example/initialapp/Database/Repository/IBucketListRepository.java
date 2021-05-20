package com.example.initialapp.Database.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Database.Authorization;
import com.example.initialapp.Database.BucketListGoals;
import com.example.initialapp.RemoteSource.WebAPI.Model.Token;

import java.util.List;

public interface IBucketListRepository {
    LiveData<BucketListGoals> getGoal();

    LiveData<List<BucketListGoals>> getAllGoals();

    void insert(BucketListGoals bucketListGoals);

    void update(BucketListGoals bucketListGoals);

    void delete(BucketListGoals bucketListGoals);

    void deleteAllGoals();

    LiveData<List<BucketListGoals>> getCompletedGoals();

    LiveData<List<Authorization>> getToken();

    void updateToken(Authorization previous, Authorization updated);

    void insertToken(Authorization authorization);

    LiveData<List<BucketListGoals>> getWishlist();
}
