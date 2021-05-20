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

    RequestManager manager = RequestManager.getInstance();

    public AllGalleryViewModel(@NonNull Application application) {
        super(application);

        // Bucket List goal values
        goalLabel = new MutableLiveData<>();
        goalIconID = new MutableLiveData<>();
        goalCheckBox = new MutableLiveData<>();

        bucketListRepository = BucketListRepository.getInstance(application);

        //TODO getBucketList doesnt work
//        manager.getBucketlist();
        fetchData();
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

    public void delete(BucketListGoals bucketListGoals){
        bucketListRepository.delete(bucketListGoals);
    }

    public void deleteAllGoals() {
        bucketListRepository.deleteAllGoals();
    }


    public void getBucketlistItem(){
        manager.getBucketlistItem();
    }

}
