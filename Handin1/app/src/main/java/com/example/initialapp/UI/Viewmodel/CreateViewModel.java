package com.example.initialapp.UI.Viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Database.Repository.IBucketListRepository;
import com.example.initialapp.EventBusObjects.GoalEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class CreateViewModel extends AndroidViewModel {
    private IBucketListRepository bucketListRepository;
    private MutableLiveData<String> nameActivity;
    private MutableLiveData<String> addLocation;

    public CreateViewModel(@NonNull Application application) {
        super(application);

        EventBus.getDefault().register(this);

        nameActivity = new MutableLiveData<>();
        addLocation = new MutableLiveData<>();
    }

    public void fetchData() {
        bucketListRepository.getGoal();
    }

    public MutableLiveData<String> getNameActivity() {
        return nameActivity;
    }

    public MutableLiveData<String> getAddLocation() {
        return addLocation;
    }

    @Subscribe
    public void onGoalEvent(GoalEvent goalEvent) {
        nameActivity.postValue(goalEvent.getGoal());
        Log.i("Goal Label", goalEvent.getGoal());

        addLocation.postValue(goalEvent.getLocation());
        Log.i("Location", goalEvent.getLocation());
    }
}
