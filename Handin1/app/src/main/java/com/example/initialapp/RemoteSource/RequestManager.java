package com.example.initialapp.RemoteSource;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Domain.GoalResponse;
import com.example.initialapp.RemoteSource.BucketListGenerator.Endpoint.BucketListAPI;
import com.example.initialapp.RemoteSource.ServiceGenerator.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestManager {

    private static RequestManager instance;
    private MutableLiveData<String> output;
    private MutableLiveData<GoalResponse> goalsResponse;
    private MutableLiveData<List<String>> goalsLive;
    private List<String> goals;
    BucketListAPI bucketListAPI;
    String user;
    private int resultStart = 0;
    public static final int RESULT_LIMIT = 100;

    private RequestManager() {

        output = new MutableLiveData<>();
        goalsResponse = new MutableLiveData<>();
        goalsLive = new MutableLiveData<>();
        goals = new ArrayList<String>();
        bucketListAPI = ServiceGenerator.getBucketListAPI();

        //It is using a specific account, but in the future each user should have its own
        user = ServiceGenerator.getAuthHeader("fanimator", "hungary");
    }

    public static synchronized RequestManager getInstance() {
        if (instance == null) {
            instance = new RequestManager();
        }
        return instance;
    }

    public MutableLiveData<List<String>> getGoal() {

        Call<GoalResponse> call = bucketListAPI.getGoal(user);
        call.enqueue(new Callback<GoalResponse>() {
            @Override
            public void onResponse(Call<GoalResponse> call, Response<GoalResponse> response) {
                goalsResponse.setValue(response.body());
                goalsLive.setValue(goalsResponse.getValue().getGoalsLabels());
            }

            @Override
            public void onFailure(Call<GoalResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong getting the goals");
            }
        });
        return goalsLive;
    }

    public MutableLiveData<List<String>> getGoalsLive() {
        return goalsLive;
    }
}

