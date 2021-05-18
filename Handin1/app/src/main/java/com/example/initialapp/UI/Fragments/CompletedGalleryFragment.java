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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.initialapp.Adapter.GoalAdapter;
import com.example.initialapp.Database.BucketListGoals;
import com.example.initialapp.R;
import com.example.initialapp.UI.Viewmodel.CompletedViewModel;

import java.util.ArrayList;
import java.util.List;

public class CompletedGalleryFragment extends Fragment {

    private View completedView;
    RecyclerView mGoalList;
    GoalAdapter mGoalAdapter;
    private TextView error;

    private CompletedViewModel completedViewModel;

    private static final String TAG = "CompletedFragment";

    private static final String ARG_SECTION_NUMBER = "section_number";

//    public static CompletedGalleryFragment newInstance(int index) {
//        CompletedGalleryFragment fragment = new CompletedGalleryFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt(ARG_SECTION_NUMBER, index);
//        fragment.setArguments(bundle);
//        return fragment;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate was called");
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        completedViewModel = new ViewModelProvider(this).get(CompletedViewModel.class);

        completedView = inflater.inflate(R.layout.fragment_completedgallery, container, false);

        initializeFragmentsValues();

        updateRecyclerView();

        // get all completed goals

        try {
            if (completedViewModel.getCompletedGoals() != null) {
                completedViewModel.getCompletedGoals().observe(getViewLifecycleOwner(), new Observer<List<BucketListGoals>>() {
                    @Override
                    public void onChanged(List<BucketListGoals> bucketListGoals) {
                        mGoalAdapter.setGoals(bucketListGoals);
                    }
                });
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
                completedViewModel.delete(mGoalAdapter. getBucketListGoalAt(viewHolder.getAdapterPosition()));
                Toast.makeText(completedView.getContext(), "Goal deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(mGoalList);

        return completedView;
    }

    private void updateRecyclerView() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    completedViewModel.fetchData();
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
        ArrayList<BucketListGoals> goals = new ArrayList<>();

        error = completedView.findViewById(R.id.error);

        //RecyclerView Setup
        mGoalList = completedView.findViewById(R.id.bucketListRecyclerView);
        mGoalList.setLayoutManager(new LinearLayoutManager(completedView.getContext()));
        mGoalList.setHasFixedSize(true);
        mGoalAdapter = new GoalAdapter();
        mGoalList.setAdapter(mGoalAdapter);
    }
}
