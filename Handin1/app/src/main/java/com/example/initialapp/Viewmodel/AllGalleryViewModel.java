package com.example.initialapp.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.initialapp.Repository.IBucketListRepository;

public class AllGalleryViewModel extends AndroidViewModel {

    private IBucketListRepository bucketListRepository;

    public AllGalleryViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchData(){
        bucketListRepository.getIdea();
    }
}
