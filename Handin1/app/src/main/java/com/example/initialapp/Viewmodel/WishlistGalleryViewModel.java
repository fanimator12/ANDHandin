package com.example.initialapp.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.initialapp.Repository.IBucketListRepository;

public class WishlistGalleryViewModel extends AndroidViewModel {

    private IBucketListRepository bucketListRepository;

    public WishlistGalleryViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchData(){
        bucketListRepository.getIdea();
    }
}
