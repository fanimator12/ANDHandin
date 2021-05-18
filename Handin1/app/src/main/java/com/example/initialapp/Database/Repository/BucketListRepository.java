package com.example.initialapp.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.initialapp.Database.BucketListDAO;
import com.example.initialapp.Database.BucketListDatabase;
import com.example.initialapp.Database.BucketListGoals;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class BucketListRepository implements IBucketListRepository {

    private BucketListDAO bucketListDAO;
    private static BucketListRepository instance;
    private LiveData<List<BucketListGoals>> allGoals;
    private LiveData<List<BucketListGoals>> typeGoals;
    private LiveData<Float> total;
    private LiveData<List<BucketListGoals>> completed;

    public BucketListRepository(Application application) {
        final BucketListDatabase database = BucketListDatabase.getInstance(application);
        bucketListDAO = database.bucketListDAO();
        allGoals = bucketListDAO.getAllGoals();
    }

    @Override
    public void getGoal(){
        bucketListDAO.getGoal();
    }

    @Override
    public void searchForGoal(String s) {
////        BucketListAPI bucketlistAPI = ServiceGenerator.getInstance();
////        Call<GoalResponse> call = bucketlistAPI.getGoal(ideaTitle);
////        call.enqueue(new Callback<GoalResponse>() {
////            @EverythingIsNonNull
////            @Override
////            public void onResponse(Call<GoalResponse> call, Response<GoalResponse> response) {
////                if (response.isSuccessful()) {
////                    searchedGoal.setValue(response.body().getGoal());
////                }
////            }
////            @EverythingIsNonNull
////            @Override
////            public void onFailure(Call<GoalResponse> call, Throwable t) {
////                Log.i("Retrofit", "Something went wrong :(");
////            }
//        });
    }

    public static synchronized BucketListRepository getInstance(Application application){
        if(instance == null)
            instance = new BucketListRepository(application);

        return instance;
    }

    @Override
    public LiveData<List<BucketListGoals>> getAllGoals(){

        return allGoals;
    }

    @Override
    public LiveData<Float> getTotalGoals(){
        total = bucketListDAO.getTotalGoals( FirebaseAuth.getInstance().getCurrentUser().getEmail());
        return total;
    }

    @Override
    public LiveData<List<BucketListGoals>> getAllGoalsByType(String type){
        typeGoals = bucketListDAO.getAllGoalsByType(type, FirebaseAuth.getInstance().getCurrentUser().getEmail());
        return typeGoals;
    }

    @Override
    public void insert(BucketListGoals bucketListGoals) {
        new InsertBucketListGoalAsync(bucketListDAO).execute(bucketListGoals);
    }

    @Override
    public void delete(BucketListGoals bucketListGoals) {
        new DeleteBucketListGoalAsync(bucketListDAO).execute(bucketListGoals);
    }

    @Override
    public void deleteAllGoals(){
        new DeleteAllGoalsAsync(bucketListDAO).execute();
    }

    @Override
    public LiveData<List<BucketListGoals>> getCompletedGoals() {
            return completed;
     }

    class InsertBucketListGoalAsync extends AsyncTask<BucketListGoals,Void,Void> {
        private BucketListDAO bucketListDAO;

        public InsertBucketListGoalAsync(BucketListDAO bucketListDAO) {
            this.bucketListDAO = bucketListDAO;
        }

        @Override
        protected Void doInBackground(BucketListGoals... bucketListGoals) {
            bucketListDAO.insert(bucketListGoals[0]);
            return null;
        }
    }

    class DeleteAllGoalsAsync extends AsyncTask<Void,Void,Void> {
        private BucketListDAO bucketListDAO;

        public DeleteAllGoalsAsync(BucketListDAO bucketListDAO) {
            this.bucketListDAO = bucketListDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            bucketListDAO.deleteAll();
            return null;
        }
    }

    class DeleteBucketListGoalAsync extends AsyncTask<BucketListGoals,Void,Void> {
        private BucketListDAO bucketListDAO;

        public DeleteBucketListGoalAsync(BucketListDAO bucketListDAO) {
            this.bucketListDAO = bucketListDAO;
        }

        @Override
        protected Void doInBackground(BucketListGoals... bucketListGoals) {
            bucketListDAO.delete(bucketListGoals[0]);
            return null;
        }
    }
}

