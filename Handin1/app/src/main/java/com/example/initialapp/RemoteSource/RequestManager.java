package com.example.initialapp.RemoteSource;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.EventBusObjects.GoalEvent;
import com.example.initialapp.RemoteSource.ServiceGenerator.ServiceGenerator;
import com.example.initialapp.RemoteSource.WebAPI.API.BucketlistApi;
import com.example.initialapp.RemoteSource.WebAPI.ApiException;
import com.example.initialapp.RemoteSource.WebAPI.Model.Bucketlist;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestManager {
    private static RequestManager instance;
    BucketlistApi bucketlistApi;
    private MutableLiveData<String> output;
    private MutableLiveData<List<String>> itemsLive;
    private List<String> items;
    String user;


    private RequestManager() {

        output = new MutableLiveData<>();
        itemsLive = new MutableLiveData<>();
        items = new ArrayList<String>();
        bucketlistApi = ServiceGenerator.getBucketListAPI();

        user =  ServiceGenerator.getAuthHeader("fanimator","hungary");
    }

    public static synchronized RequestManager getInstance() {
        if (instance == null) {
            instance = new RequestManager();
        }
        return instance;
    }


    public void getBucketlist(String activity, String location, String type, Integer imageID) throws InterruptedException, ExecutionException, TimeoutException, ApiException {

//        Call<Bucketlist> call = bucketlistApi.bucketlistGet();
//        call.enqueue(new Callback<Bucketlist>() {
//            @Override
//            public void onResponse(Call<Bucketlist> call, Response<Bucketlist> response) {
//                if (response.code() == 200) {
//                    GoalEvent event = new GoalEvent();
//                    event.setGoal(response.body().);
//                    EventBus.getDefault().post(event);
//                }
//            }
//            @Override
//            public void onFailure(Call<Bucketlist> call, Throwable t) {
//                Log.i("Retrofit", "Something went wrong");
//
//            }
//        });
//    }
}
}
