package com.example.initialapp.UI.Viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Database.BucketListGoals;
import com.example.initialapp.Database.Repository.BucketListRepository;
import com.example.initialapp.Database.Repository.IBucketListRepository;
import com.example.initialapp.EventBusObjects.GoalEvent;
import com.example.initialapp.RemoteSource.RequestManager;
import com.example.initialapp.RemoteSource.WebAPI.ApiException;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class CreateViewModel extends AndroidViewModel {
    public final static String NEW_BUCKETLIST = "Bucketlist";
    private IBucketListRepository bucketListRepository;
    private MutableLiveData<String> activity;
    private MutableLiveData<String> location;
    private MutableLiveData<String> typeSpinner;
    private MutableLiveData<Integer> imageID;
    RequestManager manager = RequestManager.getInstance();

    public CreateViewModel(@NonNull Application application) {
        super(application);

        EventBus.getDefault().register(this);

        activity = new MutableLiveData<>();
        location = new MutableLiveData<>();
        typeSpinner = new MutableLiveData<>();
        imageID = new MutableLiveData<>();

        bucketListRepository = BucketListRepository.getInstance(application);
    }

    public void fetchData() {
        bucketListRepository.getGoal();
    }

    public MutableLiveData<String> getActivity() {
        return activity;
    }

    public MutableLiveData<String> getLocation() {
        return location;
    }

    public MutableLiveData<String> getType() {
        return typeSpinner;
    }

    public MutableLiveData<Integer> getImage() {
        return imageID;
    }

    @Subscribe
    public void onGoalEvent(GoalEvent goalEvent) {
        activity.postValue(goalEvent.getGoalLabel());
        Log.i("Goal Label", goalEvent.getGoalLabel());

        location.postValue(goalEvent.getLocation());
        Log.i("Location", goalEvent.getLocation());

        typeSpinner.postValue(goalEvent.getType());
        Log.i("Type", goalEvent.getType());

        imageID.postValue(goalEvent.getImage());
        Log.i("Image", goalEvent.getImage().toString());
    }

    public void getBucketlist(String activity, String location, String type, Integer imageID) throws InterruptedException, ExecutionException, TimeoutException, ApiException {
        manager.getBucketlist(activity, location, type, imageID);
    }


    public MutableLiveData<String> getSpinnerData(){
//        typeSpinner = manager.getGoalTypes();
        return typeSpinner;
    }

    public void insert(BucketListGoals bucketListGoals){
        bucketListRepository.insert(bucketListGoals);
    }

}
