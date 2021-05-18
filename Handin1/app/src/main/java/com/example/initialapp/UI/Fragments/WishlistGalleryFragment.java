package com.example.initialapp.UI.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.initialapp.Adapter.GoalAdapter;
import com.example.initialapp.Database.BucketListGoals;
import com.example.initialapp.R;
import com.example.initialapp.UI.Viewmodel.CompletedViewModel;
import com.example.initialapp.UI.Viewmodel.WishlistGalleryViewModel;

import java.util.ArrayList;
import java.util.List;

public class WishlistGalleryFragment extends Fragment {

    private View galleryView;
    RecyclerView mGoalList;
    GoalAdapter mGoalAdapter;
    private TextView error;

    private static final String TAG = "GalleryFragment";

    private WishlistGalleryViewModel wishlistGalleryViewModel;

    private static final String ARG_SECTION_NUMBER = "section_number";

//    public static WishlistGalleryFragment newInstance(int index) {
//        WishlistGalleryFragment fragment = new WishlistGalleryFragment();
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
        wishlistGalleryViewModel = new ViewModelProvider(this).get(WishlistGalleryViewModel.class);

        galleryView = inflater.inflate(R.layout.fragment_wishlistgallery, container, false);

        initializeFragmentsValues();

        updateRecyclerView();

        // get all goals
        try {
            if (wishlistGalleryViewModel.getAllGoals() != null) {
                wishlistGalleryViewModel.getAllGoals().observe(getViewLifecycleOwner(), new Observer<List<BucketListGoals>>() {
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

        return galleryView;
    }

    private void updateRecyclerView() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    wishlistGalleryViewModel.fetchData();
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

        error = galleryView.findViewById(R.id.error);

        //RecyclerView Setup
        mGoalList = galleryView.findViewById(R.id.bucketListRecyclerView);
        mGoalList.setLayoutManager(new LinearLayoutManager(galleryView.getContext()));
        mGoalList.setHasFixedSize(true);
        mGoalAdapter = new GoalAdapter();
        mGoalList.setAdapter(mGoalAdapter);
    }
}

