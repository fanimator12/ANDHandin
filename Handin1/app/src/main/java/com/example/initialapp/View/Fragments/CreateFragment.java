package com.example.initialapp.View.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.initialapp.R;
import com.example.initialapp.Viewmodel.AllGalleryViewModel;
import com.example.initialapp.Viewmodel.CreateViewModel;

public class CreateFragment extends Fragment {
    private View createView;
    private Button addToWishListButton;

    private CreateViewModel createViewModel;

    private static final String TAG = "CreateFragment";

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static CreateFragment newInstance(int index) {
        CreateFragment fragment = new CreateFragment();
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
        createView = inflater.inflate(R.layout.fragment_create, container, false);
        addToWishListButton.setOnClickListener(view -> {
            Navigation.findNavController(createView).navigate(R.id.action_createFragment_to_galleryFragment); // TODO add validation
        });

        return createView;
    }

    private void initializeFragmentsValues() {
        createViewModel = new ViewModelProvider(this).get(CreateViewModel.class);

        addToWishListButton = createView.findViewById(R.id.addToWishListButton);
    }
}
