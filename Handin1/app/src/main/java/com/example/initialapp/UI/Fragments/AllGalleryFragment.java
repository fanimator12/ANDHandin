package com.example.initialapp.UI.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.initialapp.Adapter.GoalAdapter;
import com.example.initialapp.Database.BucketListGoals;
import com.example.initialapp.R;
import com.example.initialapp.UI.Viewmodel.AllGalleryViewModel;

import java.util.ArrayList;
import java.util.List;

public class AllGalleryFragment extends Fragment {

    private View allGalleryView;
    RecyclerView mGoalList;
    GoalAdapter mGoalAdapter;
    private TextView error;

    private MutableLiveData<List<String>> goals = new MutableLiveData<>();

    private AllGalleryViewModel allGalleryViewModel;

    private static final String TAG = "AllGalleryFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate was called");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        allGalleryViewModel = new ViewModelProvider(this).get(AllGalleryViewModel.class);

        allGalleryView = inflater.inflate(R.layout.fragment_allgallery, container, false);

        initializeFragmentsValues();

        updateRecyclerView();

        // get all goals
        try {
            if (allGalleryViewModel.getAllGoals() != null) {
                allGalleryViewModel.getAllGoals().observe(getViewLifecycleOwner(), new Observer<List<BucketListGoals>>() {
                    @Override
                    public void onChanged(List<BucketListGoals> bucketListGoals) {
                        mGoalAdapter.setGoals(bucketListGoals);
                    }
                });
                error.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            error.setVisibility(View.VISIBLE);
            e.printStackTrace();
        }

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                allGalleryViewModel.delete(mGoalAdapter. getBucketListGoalAt(viewHolder.getAdapterPosition()));
                Toast.makeText(allGalleryView.getContext(), "Goal deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(mGoalList);

        return allGalleryView;
    }

    private void updateRecyclerView() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    allGalleryViewModel.fetchData();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    private void initializeFragmentsValues() {
        goals = new MutableLiveData<>();

        error = allGalleryView.findViewById(R.id.error);

        //RecyclerView Setup
        mGoalList = allGalleryView.findViewById(R.id.bucketListRecyclerView);
        mGoalList.setLayoutManager(new LinearLayoutManager(allGalleryView.getContext()));
        mGoalList.setHasFixedSize(true);
        mGoalAdapter = new GoalAdapter();
        mGoalList.setAdapter(mGoalAdapter);
    }
}
