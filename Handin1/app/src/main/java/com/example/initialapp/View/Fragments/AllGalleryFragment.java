package com.example.initialapp.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.initialapp.R;
import com.example.initialapp.Viewmodel.AllGalleryViewModel;
import com.google.android.material.tabs.TabItem;

public class AllGalleryFragment extends Fragment {

    private TabItem allTabItem;
    private TabItem wishlistTabItem;
    private TabItem completedTabItem;
    private View allGalleryView;

    private AllGalleryViewModel allGalleryViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        allGalleryView = inflater.inflate(R.layout.fragment_allgallery,container,false);
        initializeFragmentsValues();
        allTabItem.setOnClickListener(view -> {
            Navigation.findNavController(allGalleryView).navigate(R.id.action_allGalleryFragment_to_galleryFragment); // TODO update navigation
        });

        return allGalleryView;
    }

    private void initializeFragmentsValues() {
        allTabItem = allGalleryView.findViewById(R.id.allTab);
        wishlistTabItem = allGalleryView.findViewById(R.id.wishlistTab);
        completedTabItem = allGalleryView.findViewById(R.id.completedTab);

    }
}
