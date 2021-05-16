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
    private MutableLiveData<GoalResponse> goalsResponse;
    private MutableLiveData<List<String>> goalsLive;
    private List<String> goals;
    BucketListAPI bucketListAPI;
    String user;
    Integer bucketlistID;

    private RequestManager() {

        goalsResponse = new MutableLiveData<>();
        goalsLive = new MutableLiveData<>();
        goals = new ArrayList<String>();
        bucketListAPI = ServiceGenerator.getBucketListAPI();

        //It is using a specific account, but in the future each user should have its own
        user = ServiceGenerator.getAuthHeader("fanimator", "hungary");

        bucketlistID = ServiceGenerator.getBucketListHeader(1);
    }

    public static synchronized RequestManager getInstance() {
        if (instance == null) {
            instance = new RequestManager();
        }
        return instance;
    }

    public MutableLiveData<List<String>> getGoal() {

        Call<GoalResponse> call = bucketListAPI.getBucketlist(user, bucketlistID);
        call.enqueue(new Callback<GoalResponse>() {
            @Override
            public void onResponse(Call<GoalResponse> call, Response<GoalResponse> response) {
                if (response.code() == 200) {
                    goalsResponse.setValue(response.body());
                    goalsLive.setValue(goalsResponse.getValue().getGoalsLabels());
                }
            }

            @Override
            public void onFailure(Call<GoalResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong getting the goals");
            }
        });
        return goalsLive;
    }

    public MutableLiveData<List<String>> getAllGoals() {

        Call<GoalResponse> call = bucketListAPI.listAll(user, bucketlistID);
        call.enqueue(new Callback<GoalResponse>() {
            @Override
            public void onResponse(Call<GoalResponse> call, Response<GoalResponse> response) {
                if (response.code() == 200) {
                    goalsResponse.setValue(response.body());
                    goalsLive.setValue(goalsResponse.getValue().getGoalsLabels());
                }
            }

            @Override
            public void onFailure(Call<GoalResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong listing all goals");
            }
        });
        return goalsLive;
    }


    public MutableLiveData<List<String>> getGoalsLive() {
        return goalsLive;
    }
}

