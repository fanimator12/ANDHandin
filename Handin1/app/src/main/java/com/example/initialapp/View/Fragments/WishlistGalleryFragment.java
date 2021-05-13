package com.example.initialapp.View.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.initialapp.R;
import com.example.initialapp.Viewmodel.WishlistGalleryViewModel;
import com.google.android.material.tabs.TabItem;

public class WishlistGalleryFragment extends Fragment {

    private TabItem allTabItem;
    private TabItem wishlistTabItem;
    private TabItem completedTabItem;
    private View galleryView;

    private static final String TAG = "GalleryFragment";

    private WishlistGalleryViewModel wishlistGalleryViewModel;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static WishlistGalleryFragment newInstance(int index) {
        WishlistGalleryFragment fragment = new WishlistGalleryFragment();
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        galleryView = inflater.inflate(R.layout.fragment_wishlistgallery, container, false);
        allTabItem.setOnClickListener(view -> {
            Navigation.findNavController(galleryView).navigate(R.id.action_galleryFragment_to_allGalleryFragment); // TODO update navigation
        });

        return galleryView;
    }
}

