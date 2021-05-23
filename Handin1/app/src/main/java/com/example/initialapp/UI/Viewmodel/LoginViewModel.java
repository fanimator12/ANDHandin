package com.example.initialapp.UI.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.initialapp.Database.Authorization;
import com.example.initialapp.Database.Repository.BucketListRepository;
import com.example.initialapp.Database.Repository.IBucketListRepository;
import com.example.initialapp.RemoteSource.RequestManager;
import com.example.initialapp.RemoteSource.WebAPI.Model.Token;

public class LoginViewModel extends AndroidViewModel {
    private IBucketListRepository bucketListRepository;
    private MutableLiveData<Token> token;
    Authorization authorization, newAuthorization;
    RequestManager requestManager = RequestManager.getInstance();

    public LoginViewModel(@NonNull Application application) {
        super(application);

        bucketListRepository = BucketListRepository.getInstance(application);

        token = new MutableLiveData<>();
        requestManager.postLogin();
    }

    public void postLogin(){
       token = requestManager.postLogin();
       newAuthorization = new Authorization("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTYsImV4cCI6MTYyMTY0MDkzMH0.EB0tVMntHPYFLMqSyy5RGHN-bH7c19HOjpTV258usok");
    }
}
