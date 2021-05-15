package com.example.initialapp.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.initialapp.Database.Repository.IBucketListRepository;

public class CompletedViewModel extends AndroidViewModel {

    private IBucketListRepository bucketListRepository;

    public CompletedViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchData(){
        bucketListRepository.getAllGoals();
    }
}
