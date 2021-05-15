package com.example.initialapp.View.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.initialapp.R;
import com.example.initialapp.Viewmodel.CreateViewModel;

public class CreateFragment extends Fragment {
    private View createView;
    private TextView createTextView;
    private TextView activityTextView;
    private TextView locationTextView;
    private TextView pictureTextView;
    private EditText nameActivity;
    private EditText addLocation;
    private Button imageButton;
    private Button addToWishListButton;

    InputMethodManager methodManager;

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

        Log.d(TAG, "onCreate was called");
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        createView = inflater.inflate(R.layout.fragment_create, container, false);

        initializeFragmentsValues();

        setUpObserver();
        updateRecyclerView();

        addToWishListButton.setOnClickListener(view -> {
            Navigation.findNavController(createView).navigate(R.id.action_createFragment_to_galleryFragment); // TODO add validation
        });

        return createView;
    }

    private void initializeFragmentsValues() {
        createViewModel = new ViewModelProvider(this).get(CreateViewModel.class);

        createTextView = createView.findViewById(R.id.createTextView);
        activityTextView = createView.findViewById(R.id.activityTextView);
        locationTextView = createView.findViewById(R.id.locationTextView);
        pictureTextView = createView.findViewById(R.id.pictureTextView);

        nameActivity = createView.findViewById(R.id.nameActivityHint);
        addLocation = createView.findViewById(R.id.addLocationHint);

        imageButton = createView.findViewById(R.id.imageButton);
        addToWishListButton = createView.findViewById(R.id.addToWishListButton);

        //Used for loading panel
        createView.findViewById(R.id.loadingPanel).setVisibility(View.GONE);

        //Used to closed the keyboard after input
        methodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        setUpObserver();
        updateRecyclerView();
    }

    private void updateRecyclerView(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    createViewModel.fetchData();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        });
        thread.start();
    }
// TODO this might be completely useless
    private void setUpObserver() {
        createViewModel.getNameActivity().observe(getViewLifecycleOwner(), goalLabel -> {
            nameActivity.setText(goalLabel);
        });

        createViewModel.getNameActivity().observe(getViewLifecycleOwner(), goalLocation -> {
            addLocation.setText(goalLocation);
        });

    }
}
