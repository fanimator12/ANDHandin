package com.example.initialapp.View.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
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
import com.example.initialapp.Domain.Goal;
import com.example.initialapp.R;
import com.example.initialapp.Viewmodel.AllGalleryViewModel;
import com.google.android.material.tabs.TabItem;

import java.util.ArrayList;
import java.util.List;

public class AllGalleryFragment extends Fragment implements GoalAdapter.OnListGoalClickListener {

    private View allGalleryView;
    RecyclerView mGoalList;
    GoalAdapter mGoalAdapter;

    private MutableLiveData<List<String>> list = new MutableLiveData<>();

    private AllGalleryViewModel allGalleryViewModel;

    private static final String TAG = "AllGalleryFragment";

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static AllGalleryFragment newInstance(int index) {
        AllGalleryFragment fragment = new AllGalleryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate was called");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        allGalleryView = inflater.inflate(R.layout.fragment_allgallery, container, false);
        initializeFragmentsValues();
//        allTabItem.setOnClickListener(view -> {
//            Navigation.findNavController(allGalleryView).navigate(R.id.action_allGalleryFragment_to_galleryFragment); // TODO update navigation
//        });

        allGalleryViewModel = new ViewModelProvider(this).get(AllGalleryViewModel.class);

        // get all goals
        allGalleryViewModel.getAllGoals().observe(getViewLifecycleOwner(), new Observer<List<BucketListGoals>>() {
            @Override
            public void onChanged(List<BucketListGoals> bucketListGoals) {
                mGoalAdapter.setGoals(bucketListGoals);
            }
        });

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

    private void initializeFragmentsValues() {
        ArrayList<BucketListGoals> goals = new ArrayList<>();

        //RecyclerView Setup
        mGoalList = allGalleryView.findViewById(R.id.bucketListRecyclerView);
        mGoalList.setLayoutManager(new LinearLayoutManager(allGalleryView.getContext()));
        mGoalList.setHasFixedSize(true);
        mGoalAdapter = new GoalAdapter(goals, this);
        mGoalList.setAdapter(mGoalAdapter);
    }

    @Override
    public void onListGoalClick(int clickedGoalIndex) {
        int goalNumber = clickedGoalIndex + 1;
        //Toast.makeText(this, "Goal Number: " + goalNumber, Toast.LENGTH_SHORT).show();
    }
}
