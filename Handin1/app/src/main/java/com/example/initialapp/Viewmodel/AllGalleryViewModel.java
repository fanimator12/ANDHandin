package com.example.initialapp.Viewmodel;

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

    private IBucketListRepository bucketListRepository;
    private MutableLiveData<String> goalLabel;
    private MutableLiveData<Integer> goalIconID;
    RequestManager requestManager = RequestManager.getInstance();

    public AllGalleryViewModel(@NonNull Application application) {
        super(application);

        // Bucket List goal values
        goalLabel = new MutableLiveData<>();
        goalIconID = new MutableLiveData<>();

        bucketListRepository = new BucketListRepository(application);
    }

    public void getGoal() {
        bucketListRepository.getGoal();
    }

    public void searchForGoal(String s) {
        bucketListRepository.searchForGoal(s);
    }

    public MutableLiveData<String> getGoalLabel() {
        return goalLabel;
    }

    public MutableLiveData<Integer> getGoalIconID() {
        return goalIconID;
    }

    public void fetchData(){
        bucketListRepository.getAllGoals();
    }

    public LiveData<List<BucketListGoals>> getAllGoals() {
        return bucketListRepository.getAllGoals();
    }

    public void insert(BucketListGoals bucketListGoals){
        bucketListRepository.insert(bucketListGoals);
    }

    public void delete(BucketListGoals bucketListGoals){
        bucketListRepository.delete(bucketListGoals);
    }

    public void deleteAllGoals() {
        bucketListRepository.deleteAllGoals();
    }

}
