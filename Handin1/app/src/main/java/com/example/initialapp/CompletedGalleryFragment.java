package com.example.initialapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.tabs.TabItem;

public class CompletedGalleryFragment extends Fragment {

    private TabItem allTabItem;
    private TabItem wishlistTabItem;
    private TabItem completedTabItem;
    private View galleryView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        galleryView = inflater.inflate(R.layout.fragment_completedgallery,container,false);
        allTabItem.setOnClickListener(view -> {
            Navigation.findNavController(galleryView).navigate(R.id.action_galleryFragment_to_allGalleryFragment); // TODO update navigation
        });

        return galleryView;
    }
}
