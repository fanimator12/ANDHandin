package com.example.initialapp.UI.Viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Database.Repository.BucketListRepository;
import com.example.initialapp.Database.Repository.IBucketListRepository;
import com.example.initialapp.EventBusObjects.GoalEvent;

import org.greenrobot.eventbus.Subscribe;

public class FrontPageViewModel extends AndroidViewModel {

    private IBucketListRepository bucketListRepository;

    private MutableLiveData<String> completedGoals;

    public FrontPageViewModel(@NonNull Application application) {
        super(application);

        completedGoals = new MutableLiveData<>();

        bucketListRepository = BucketListRepository.getInstance(application);
    }

    public void fetchData() {
        bucketListRepository.getCompletedGoals();
    }

    public MutableLiveData<String> getCompletedGoals() {
        return completedGoals;
    }

    @Subscribe
    public void onGoalEvent(GoalEvent goalEvent){
        completedGoals.postValue(goalEvent.getCompletedGoals());
        Log.i("Completed Goals", goalEvent.getCompletedGoals());
    }
}
