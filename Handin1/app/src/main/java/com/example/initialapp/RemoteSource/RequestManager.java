package com.example.initialapp.RemoteSource;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.EventBusObjects.GoalEvent;
import com.example.initialapp.RemoteSource.ServiceGenerator.ServiceGenerator;
import com.example.initialapp.RemoteSource.WebAPI.Model.Auth;
import com.example.initialapp.RemoteSource.WebAPI.Model.Bucketlist;
import com.example.initialapp.RemoteSource.WebAPI.Model.Item;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestManager {
    private static RequestManager instance;
    BucketListAPI bucketlistAPI;
    private MutableLiveData<String> output;
    Item item;
    Bucketlist bucketlist;
    private MutableLiveData<List<String>> bucketlistLive;
    private List<String> bucketlists;
    String user;

    private int resultStart = 0;
    public static final int RESULT_LIMIT = 100;

    private RequestManager() {

        output = new MutableLiveData<>();
        bucketlistLive = new MutableLiveData<>();
        bucketlists = new ArrayList<String>();
        bucketlistAPI = ServiceGenerator.getBucketListAPI();

        //specific user so far
        //TODO
//        String email = (String) Auth.setEmail("franciska.torok@yahoo.com");
//        String password = (String) Auth.setPassword("hungary");
//        user = ServiceGenerator.getAuthHeader(email, password);
    }

    public static synchronized RequestManager getInstance() {
        if (instance == null) {
            instance = new RequestManager();
        }
        return instance;
    }

    public void getBucketlist() {

        Call<Bucketlist> call = bucketlistAPI.getBucketlist(bucketlist.toString());
        call.enqueue(new Callback<Bucketlist>() {
            @Override
            public void onResponse(Call<Bucketlist> call, Response<Bucketlist> response) {
                if (response.code() == 200) {
                    GoalEvent event = new GoalEvent();
                    event.setGoalLabel(response.body().getTitle()+"");
                    EventBus.getDefault().post(event);
                }
            }
            @Override
            public void onFailure(Call<Bucketlist> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");

            }
        });
    }

    public void getBucketlistItem() {

        Call<Bucketlist> call = bucketlistAPI.getBucketlistItem(item);
        call.enqueue(new Callback<Bucketlist>() {
            @Override
            public void onResponse(Call<Bucketlist> call, Response<Bucketlist> response) {
                if (response.code() == 200) {
                    GoalEvent event = new GoalEvent();
                    event.setGoalLabel(response.body().getTitle()+"");
                    EventBus.getDefault().post(event);
                }
            }
            @Override
            public void onFailure(Call<Bucketlist> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");

            }
        });
    }

    public void postBucketlistItem(String activity) {

        Call<Item> call = bucketlistAPI.postBucketlistItem(activity);
        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                if (response.code() == 200) {
                    GoalEvent event = new GoalEvent();
                    event.setGoalLabel(response.body().getName()+"");
                    EventBus.getDefault().post(event);
                }
            }
            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");

            }
        });
    }

    public void postRegister() {

        Call<Auth> call = bucketlistAPI.postRegister(user);
        call.enqueue(new Callback<Auth>() {
            @Override
            public void onResponse(Call<Auth> call, Response<Auth> response) {
                if (response.code() == 200) {
                    Log.i("Retrofit", "Authorization enabled");
                }
            }
            @Override
            public void onFailure(Call<Auth> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }

    public void postLogin() {

        Call<Auth> call = bucketlistAPI.postLogin(user);
        call.enqueue(new Callback<Auth>() {
            @Override
            public void onResponse(Call<Auth> call, Response<Auth> response) {
                if (response.code() == 200) {
                    Log.i("Retrofit", "Authorization enabled");
                }
            }
            @Override
            public void onFailure(Call<Auth> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }
}
