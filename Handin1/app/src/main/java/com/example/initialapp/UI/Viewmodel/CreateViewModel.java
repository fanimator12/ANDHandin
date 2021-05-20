package com.example.initialapp.UI.Viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Database.BucketListGoals;
import com.example.initialapp.Database.Repository.BucketListRepository;
import com.example.initialapp.Database.Repository.IBucketListRepository;
import com.example.initialapp.EventBusObjects.GoalEvent;
import com.example.initialapp.RemoteSource.RequestManager;
import com.google.firebase.auth.FirebaseAuth;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class CreateViewModel extends AndroidViewModel {
    public final static String NEW_BUCKETLIST_ITEM = "Bucketlist";
    private IBucketListRepository bucketListRepository;
    private MutableLiveData<String> activity;
    RequestManager manager = RequestManager.getInstance();


    public CreateViewModel(Application application) {
        super(application);

        EventBus.getDefault().register(this);

        activity = new MutableLiveData<>();

        bucketListRepository = BucketListRepository.getInstance(application);
    }

    public void fetchData() {
        bucketListRepository.getGoal();
    }

    public MutableLiveData<String> getActivity() {
        return activity;
    }

    @Subscribe
    public void onGoalEvent(GoalEvent goalEvent) {
        activity.postValue(goalEvent.getGoalLabel());
        Log.i("Goal Label", goalEvent.getGoalLabel());
    }

    public void postBucketlist(String activity) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTYsImV4cCI6MTYyMTY0MDkzMH0.EB0tVMntHPYFLMqSyy5RGHN-bH7c19HOjpTV258usok";
        manager.postBucketlist(token, activity);

        BucketListGoals bucketListGoals = new BucketListGoals(FirebaseAuth.getInstance().getCurrentUser().getEmail(), activity);
        bucketListRepository.insert(bucketListGoals);
    }


    public void insert(BucketListGoals bucketListGoals) {
        bucketListRepository.insert(bucketListGoals);
    }

}
