package com.example.initialapp.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Database.Repository.BucketListRepository;
import com.example.initialapp.Database.Repository.IBucketListRepository;

public class FrontPageViewModel extends AndroidViewModel {

    private IBucketListRepository bucketListRepository;
    private MutableLiveData<String> goalLabel;
    private MutableLiveData<Integer> goalIconID;
    private MutableLiveData<String> completedGoals;

    public FrontPageViewModel(@NonNull Application application) {
        super(application);

        bucketListRepository = BucketListRepository.getInstance(application);
    }

    public void fetchData() {
        bucketListRepository.getCompletedGoals();
    }

    public MutableLiveData<String> getCompletedGoals() {
        return completedGoals;
    }
}
