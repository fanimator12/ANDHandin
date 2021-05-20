package com.example.initialapp.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BucketListDAO {

    @Insert
    void insert(BucketListGoals bucketListGoals);

    @Update
    void update(BucketListGoals bucketListGoals);

    @Delete
    void delete(BucketListGoals bucketListGoals);

    @Query("DELETE FROM bucketlist_goals")
    void deleteAll();

    @Query("SELECT * FROM bucketlist_goals ORDER BY id DESC")
    LiveData<List<BucketListGoals>> getAllGoals();

    @Query("SELECT goal FROM bucketlist_goals")
    LiveData<String> getGoal();

    @Query("SELECT * FROM bucketlist_goals WHERE completed IS 'true'")
    LiveData<List<BucketListGoals>> getCompletedGoals();

    @Insert
    void insert(Authorization authorization);

    @Delete
    void delete(Authorization authorization);

    @Query("SELECT * FROM authorization ")
    LiveData<List<Authorization>> getToken();
}

