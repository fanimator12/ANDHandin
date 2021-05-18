package com.example.initialapp.UI.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.initialapp.R;
import com.example.initialapp.UI.Viewmodel.DescriptionViewModel;

public class DescriptionFragment extends Fragment {
    private View descriptionView;
    private Button addToWishListButton;
    private TextView title;
    private ImageView image;
    private TextView location;
    private CheckBox checkbox;

    private DescriptionViewModel descriptionViewModel;

    private static final String TAG = "DescriptionFragment";

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static DescriptionFragment newInstance(int index) {
        DescriptionFragment fragment = new DescriptionFragment();
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
        descriptionView = inflater.inflate(R.layout.fragment_description, container, false);

        initializeFragmentsValues();

        return descriptionView;
    }

    private void initializeFragmentsValues() {
        descriptionViewModel = new ViewModelProvider(this).get(DescriptionViewModel.class);

        addToWishListButton = descriptionView.findViewById(R.id.addButton);
        title = descriptionView.findViewById(R.id.goal_title);
        image = descriptionView.findViewById(R.id.imageView);
        location = descriptionView.findViewById(R.id.location);
        checkbox = descriptionView.findViewById(R.id.checkBox);
    }
}
