package com.example.initialapp.View.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.initialapp.Adapter.IdeaAdapter;
import com.example.initialapp.R;
import com.example.initialapp.Viewmodel.AllGalleryViewModel;
import com.example.initialapp.Viewmodel.CompletedViewModel;
import com.google.android.material.tabs.TabItem;

public class CompletedGalleryFragment extends Fragment {

    private TabItem allTabItem;
    private TabItem wishlistTabItem;
    private TabItem completedTabItem;
    private View galleryView;

    private CompletedViewModel completedViewModel;

    private static final String TAG = "CompletedFragment";

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static CompletedGalleryFragment newInstance(int index) {
        CompletedGalleryFragment fragment = new CompletedGalleryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeFragmentsValues();

        Log.d(TAG, "onCreate was called");
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        galleryView = inflater.inflate(R.layout.fragment_completedgallery, container, false);
        allTabItem.setOnClickListener(view -> {
            Navigation.findNavController(galleryView).navigate(R.id.action_galleryFragment_to_allGalleryFragment); // TODO update navigation
        });

        return galleryView;
    }

    private void initializeFragmentsValues() {

        completedViewModel = new ViewModelProvider(this).get(CompletedViewModel.class);

        allTabItem = galleryView.findViewById(R.id.allTab);
        wishlistTabItem = galleryView.findViewById(R.id.wishlistTab);
        completedTabItem = galleryView.findViewById(R.id.completedTab);

        updateRecyclerView();
    }

    private void updateRecyclerView() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    completedViewModel.fetchData();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
