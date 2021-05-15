package com.example.initialapp.Database.Repository;

import androidx.lifecycle.LiveData;

import com.example.initialapp.Database.BucketListGoals;

import java.util.List;

public interface IBucketListRepository {
    void getGoal();

    void searchForGoal(String s);

    LiveData<List<BucketListGoals>> getAllGoals();

    LiveData<Float> getTotalGoals();

    LiveData<List<BucketListGoals>> getAllGoalsByType(String type);

    void insert(BucketListGoals bucketListGoals);

    void delete(BucketListGoals bucketListGoals);

    void deleteAllGoals();
}
