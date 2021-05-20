package com.example.initialapp.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.initialapp.Database.BucketListDAO;
import com.example.initialapp.Database.BucketListDatabase;
import com.example.initialapp.Database.BucketListGoals;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//this is the model in MVVM technically
public class BucketListRepository implements IBucketListRepository {

    private BucketListDAO bucketListDAO;
    private static BucketListRepository instance;
    private LiveData<List<BucketListGoals>> allGoals;
    private LiveData<List<BucketListGoals>> completed;
    private LiveData<BucketListGoals> goal;
    private final ExecutorService executorService;

    public BucketListRepository(Application application) {
        final BucketListDatabase database = BucketListDatabase.getInstance(application);
        bucketListDAO = database.bucketListDAO();
        allGoals = bucketListDAO.getAllGoals();
        completed = bucketListDAO.getCompletedGoals();
        executorService = Executors.newFixedThreadPool(2);
    }

    @Override
    public LiveData<BucketListGoals> getGoal() {
        executorService.execute(() -> bucketListDAO.getGoal());
        return null;
    }

    public static synchronized BucketListRepository getInstance(Application application) {
        if (instance == null)
            instance = new BucketListRepository(application);

        return instance;
    }

    @Override
    public LiveData<List<BucketListGoals>> getAllGoals() {

        return allGoals;
    }

    @Override
    public void insert(BucketListGoals bucketListGoals) {
        executorService.execute(() -> new InsertBucketListGoalAsync(bucketListDAO).execute(bucketListGoals));
    }

    @Override
    public void delete(BucketListGoals bucketListGoals) {
        executorService.execute(() -> new DeleteBucketListGoalAsync(bucketListDAO).execute(bucketListGoals));
    }

    @Override
    public void deleteAllGoals() {
        executorService.execute(() -> new DeleteAllGoalsAsync(bucketListDAO).execute());
    }

    @Override
    public LiveData<List<BucketListGoals>> getCompletedGoals() {
        return completed;
    }

    class InsertBucketListGoalAsync extends AsyncTask<BucketListGoals, Void, Void> {
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

    class DeleteAllGoalsAsync extends AsyncTask<Void, Void, Void> {
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

    class DeleteBucketListGoalAsync extends AsyncTask<BucketListGoals, Void, Void> {
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

