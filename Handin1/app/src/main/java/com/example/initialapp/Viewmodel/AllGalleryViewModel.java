package com.example.initialapp.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.initialapp.Repository.BucketListRepository;
import com.example.initialapp.Repository.IBucketListRepository;

public class AllGalleryViewModel extends AndroidViewModel {

    private IBucketListRepository bucketListRepository;
    private MutableLiveData<String> ideaTitle;
    private MutableLiveData<Integer> ideaIconID;

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Bucket List item: " + input;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }

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
