package com.example.initialapp.RemoteSource;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Database.Authorization;
import com.example.initialapp.EventBusObjects.GoalEvent;
import com.example.initialapp.RemoteSource.ServiceGenerator.ServiceGenerator;
import com.example.initialapp.RemoteSource.WebAPI.Model.Auth;
import com.example.initialapp.RemoteSource.WebAPI.Model.Bucketlist;
import com.example.initialapp.RemoteSource.WebAPI.Model.Item;
import com.example.initialapp.RemoteSource.WebAPI.Model.Token;

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
    private MutableLiveData<Token> token;
    Item item;
    Bucketlist bucketlist;
    private MutableLiveData<List<String>> bucketlistLive;
    private List<String> bucketlists;
    private Auth user;

    private int resultStart = 0;
    public static final int RESULT_LIMIT = 100;

    private RequestManager() {

        output = new MutableLiveData<>();
        bucketlistLive = new MutableLiveData<>();
        token = new MutableLiveData<Token>();
        bucketlists = new ArrayList<String>();
        bucketlistAPI = ServiceGenerator.getBucketListAPI();
        bucketlistLive = new MutableLiveData<List<String>>();

        //specific user so far
        //TODO
        user = new Auth();
        user.setEmail("franciskaltorok@gmail.com");
        user.setPassword("hungaryhungary");
    }

    public static synchronized RequestManager getInstance() {
        if (instance == null) {
            instance = new RequestManager();
        }
        return instance;
    }

    public MutableLiveData<List<String>> getBucketlist(String token) {
        Call<List<Bucketlist>> call = bucketlistAPI.getBucketlist(token);
        call.enqueue(new Callback<List<Bucketlist>>() {
            @Override
            public void onResponse(Call<List<Bucketlist>> call, Response<List<Bucketlist>> response) {
                if (response.code() == 200) {

                    List<String> stringList = new ArrayList<String>();

                    for ( int i = 0; i < response.body().size();i++) {
                        GoalEvent event = new GoalEvent();
                        event.setGoalLabel(response.body().get(i).getTitle());
                        EventBus.getDefault().post(event);
                    }

                    bucketlistLive.setValue(stringList);
                }
            }
            @Override
            public void onFailure(Call<List<Bucketlist>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");

            }
        });

        return bucketlistLive;
    }

//    public void getBucketlistItem(String token) {
//
//        Call<Bucketlist> call = bucketlistAPI.getBucketlistItem(token, item);
//        call.enqueue(new Callback<Bucketlist>() {
//            @Override
//            public void onResponse(Call<Bucketlist> call, Response<Bucketlist> response) {
//                if (response.code() == 200) {
//                    GoalEvent event = new GoalEvent();
//                    event.setGoalLabel(response.body().getTitle()+"");
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

    public void postBucketlist(String token, String activity) {
        Bucketlist bucketlist = new Bucketlist();
        bucketlist.setTitle(activity);
        Call<Bucketlist> call = bucketlistAPI.postBucketlist(token, bucketlist);
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

    public MutableLiveData<Token> postLogin() {

        Call<Token> call = bucketlistAPI.postLogin(user);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.code() == 200) {
                    token.setValue(response.body());

                    Log.i("Retrofit", "Authorization enabled");
                }
            }
            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
        return token;
    }
}
