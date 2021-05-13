package com.example.initialapp.View.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.initialapp.Adapter.IdeaAdapter;
import com.example.initialapp.Adapter.SectionsPagerAdapter;
import com.example.initialapp.Domain.Idea;
import com.example.initialapp.R;
import com.example.initialapp.Viewmodel.AllGalleryViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class AllGalleryFragment extends Fragment implements IdeaAdapter.OnListIdeaClickListener {

    private View allGalleryView;
    private TabItem allTabItem;
    private TabItem wishlistTabItem;
    private TabItem completedTabItem;

    // for the bucket list recyclerview
    RecyclerView mIdeaList;
    IdeaAdapter mIdeaAdapter;

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

        allGalleryViewModel = new ViewModelProvider(this).get(AllGalleryViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }

        allGalleryViewModel.setIndex(index);
        ArrayList<Idea> ideas = new ArrayList<>();

        for (Idea idea : ideas) {
            ideas.add(new Idea("idea", R.drawable.ideaicon));
        }

        mIdeaAdapter = new IdeaAdapter(ideas, this);
        mIdeaList.setAdapter(mIdeaAdapter);

        Log.d(TAG, "onCreate was called");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        allGalleryView = inflater.inflate(R.layout.fragment_allgallery, container, false);
        initializeFragmentsValues();
        allTabItem.setOnClickListener(view -> {
            Navigation.findNavController(allGalleryView).navigate(R.id.action_allGalleryFragment_to_galleryFragment); // TODO update navigation
        });

        /*allGalleryViewModel.getIdeaTitle().observe(this, new Observer<Idea>() {
            @Override
            public void onChanged(@Nullable Idea idea) {
                mIdeaList.set(idea);
            }
        });*/

        return allGalleryView;
    }

    private void initializeFragmentsValues() {

        allGalleryViewModel = new ViewModelProvider(this).get(AllGalleryViewModel.class);

        allTabItem = allGalleryView.findViewById(R.id.allTab);
        wishlistTabItem = allGalleryView.findViewById(R.id.wishlistTab);
        completedTabItem = allGalleryView.findViewById(R.id.completedTab);
        mIdeaList = allGalleryView.findViewById(R.id.bucketListRecyclerView);

        mIdeaList.hasFixedSize();
        //mIdeaList.setLayoutManager(new LinearLayoutManager(this));

        updateRecyclerView();
    }

    private void updateRecyclerView() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    allGalleryViewModel.fetchData();
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

    @Override
    public void onListIdeaClick(int clickedIdeaIndex) {
        int ideaNumber = clickedIdeaIndex + 1;
        //Toast.makeText(this, "Idea Number: " + ideaNumber, Toast.LENGTH_SHORT).show();
    }
}
