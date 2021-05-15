package com.example.initialapp.RemoteSource.BucketListRemoteSource;

import com.example.initialapp.Domain.Goal;
import com.example.initialapp.RemoteSource.BucketListGenerator.BucketListGenerator;
import com.example.initialapp.RemoteSource.BucketListGenerator.Endpoint.BucketListAPI;
import com.example.initialapp.RemoteSource.BucketListGenerator.IBucketListGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class BucketListRemoteDataSource implements IBucketListRemoteDataSource {
    private IBucketListGenerator bucketListGenerator;

    public BucketListRemoteDataSource() {
        bucketListGenerator = new BucketListGenerator();
    }

    @Override
    public void getGoal() {
        BucketListAPI bucketListAPI = bucketListGenerator.getGoalAPI();
//        Call<Goal> call = bucketListAPI.getGoal();
//        call.enqueue(new Callback<Goal>() {
//            @EverythingIsNonNull
//            @Override
//            public void onResponse(Call<Goal> call, Response<Goal> response) {
//         /*       if (response.isSuccessful()) {
//                    IdeaEvent event = new IdeaEvent();
//                    event.setIdea(response.body().getIdea()+"");
//                    EventBus.getDefault().post(event);
//                }*/
//            }
//
//            @EverythingIsNonNull
//            @Override
//            public void onFailure(Call<Goal> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
    }
}
