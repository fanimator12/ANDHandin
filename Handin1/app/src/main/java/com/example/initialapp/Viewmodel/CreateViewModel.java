package com.example.initialapp.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.initialapp.Repository.IBucketListRepository;

public class CreateViewModel extends AndroidViewModel {
    private IBucketListRepository bucketListRepository;

    public CreateViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchData(){
        bucketListRepository.getIdea();
    }
}
