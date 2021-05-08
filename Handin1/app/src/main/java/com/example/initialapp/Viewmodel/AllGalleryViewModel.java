package com.example.initialapp.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Repository.BucketListRepository;
import com.example.initialapp.Repository.IBucketListRepository;

public class AllGalleryViewModel extends AndroidViewModel {

    private IBucketListRepository bucketListRepository;
    private MutableLiveData<String> ideaTitle;
    private MutableLiveData<Integer> ideaIconID;

    public AllGalleryViewModel(@NonNull Application application) {
        super(application);

        // Bucket List idea values
        ideaTitle = new MutableLiveData<>();
        ideaIconID = new MutableLiveData<>();

        bucketListRepository = new BucketListRepository(application);
    }

    public MutableLiveData<String> getIdeaTitle() {
        return ideaTitle;
    }

    public MutableLiveData<Integer> getIdeaIconID() {
        return ideaIconID;
    }

    public void fetchData(){
        bucketListRepository.getIdea();
    }
}
