package com.example.initialapp.RemoteSource.BucketListRemoteSource;

import com.example.initialapp.Domain.Idea;
import com.example.initialapp.RemoteSource.BucketListGenerator.BucketListGenerator;
import com.example.initialapp.RemoteSource.BucketListGenerator.Endpoint.BucketListAPI;
import com.example.initialapp.RemoteSource.BucketListGenerator.IBucketListGenerator;

import okhttp3.internal.annotations.EverythingIsNonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BucketListRemoteDataSource {
    private IBucketListGenerator bucketListGenerator;

    public BucketListRemoteDataSource() {
     //   bucketListGenerator = new BucketListGenerator();
    }

   // @Override
    public void getIdea() {
        BucketListAPI bucketListAPI = bucketListGenerator.getIdeaAPI();
        Call<Idea> call = bucketListAPI.getIdea(1);
        call.enqueue(new Callback<Idea>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<Idea> call, Response<Idea> response) {
         /*       if (response.isSuccessful()) {
                    IdeaEvent event = new IdeaEvent();
                    event.setIdea(response.body().getIdea()+"");
                    EventBus.getDefault().post(event);
                }*/
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<Idea> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
