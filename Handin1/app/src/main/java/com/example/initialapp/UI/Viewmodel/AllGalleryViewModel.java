package com.example.initialapp.UI.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Database.BucketListGoals;
import com.example.initialapp.Database.Repository.BucketListRepository;
import com.example.initialapp.Database.Repository.IBucketListRepository;
import com.example.initialapp.RemoteSource.RequestManager;

import java.util.List;

public class AllGalleryViewModel extends AndroidViewModel {

    IBucketListRepository bucketListRepository;
    private MutableLiveData<String> goalLabel;
    private MutableLiveData<Boolean> goalCheckBox;
    private MutableLiveData<Integer> goalIconID;
    private MutableLiveData<List<String>> items;

    String token;

    RequestManager manager = RequestManager.getInstance();

    public AllGalleryViewModel(@NonNull Application application) {
        super(application);

        // Bucket List goal values
        goalLabel = new MutableLiveData<>();
        goalIconID = new MutableLiveData<>();
        goalCheckBox = new MutableLiveData<>();

        items = new MutableLiveData<>();

        bucketListRepository = BucketListRepository.getInstance(application);

        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTYsImV4cCI6MTYyMTY0MDkzMH0.EB0tVMntHPYFLMqSyy5RGHN-bH7c19HOjpTV258usok";

        manager.getBucketlist(token);
        fetchData();
    }

    public MutableLiveData<List<String>> getItems() {
        return items;
    }

    public void getGoal() {
        bucketListRepository.getGoal();
    }

    public MutableLiveData<String> getGoalLabel() {
        return goalLabel;
    }

    public MutableLiveData<Integer> getGoalIconID() {
        return goalIconID;
    }

    public MutableLiveData<Boolean> getGoalCheckBox() {
        return goalCheckBox;
    }

    public void fetchData(){
        bucketListRepository.getAllGoals();
        bucketListRepository.getCompletedGoals();
    }

    public LiveData<List<BucketListGoals>> getAllGoals() {
        return bucketListRepository.getAllGoals();
    }

    public LiveData<List<String>> getBucketlist(){
        items = manager.getBucketlist(token);
        return items;
    }

    public void delete(BucketListGoals bucketListGoals){
        bucketListRepository.delete(bucketListGoals);
    }

}
