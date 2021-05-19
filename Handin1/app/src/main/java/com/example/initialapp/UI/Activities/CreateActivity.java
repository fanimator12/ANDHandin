package com.example.initialapp.UI.Activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.initialapp.R;
import com.example.initialapp.UI.Viewmodel.CreateViewModel;

public class CreateActivity extends AppCompatActivity {
    private View createView;
    private TextView createTextView;
    private TextView activityTextView;
    private TextView locationTextView;
    private TextView typeTextView;
    private TextView pictureTextView;
    private EditText nameActivity;
    private EditText addLocation;
    private Button imageButton;
    private Button addToWishListButton;
    private Spinner spinner;

    InputMethodManager methodManager;

    private CreateViewModel createViewModel;

    private static final String TAG = "CreateActivity";

    private static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        initializeValues();

        setUpObserver();

        Log.d(TAG, "onCreate was called");
    }

    private void initializeValues() {
//        createViewModel = new ViewModelProvider(this).get(CreateViewModel.class);
// TODO 
        createTextView = createView.findViewById(R.id.createTextView);
        activityTextView = createView.findViewById(R.id.activityTextView);
        locationTextView = createView.findViewById(R.id.locationTextView);
        pictureTextView = createView.findViewById(R.id.pictureTextView);
        typeTextView = createTextView.findViewById(R.id.typeTextView);

        nameActivity = createView.findViewById(R.id.nameActivityHint);
        addLocation = createView.findViewById(R.id.addLocationHint);

        imageButton = createView.findViewById(R.id.imageButton);
        addToWishListButton = createView.findViewById(R.id.addToWishListButton);

        spinner = createView.findViewById(R.id.spinner);

        //Used for loading panel
        createView.findViewById(R.id.loadingPanel).setVisibility(View.GONE);

//        //Used to closed the keyboard after input
//        methodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        setUpObserver();
    }

// TODO this might be completely useless
    private void setUpObserver() {
//        createViewModel.getNameActivity().observe(getViewLifecycleOwner(), goalLabel -> {
//            nameActivity.setText(goalLabel);
//        });
//
//        createViewModel.getAddLocation().observe(getViewLifecycleOwner(), goalLocation -> {
//            addLocation.setText(goalLocation);
//        });

    }
}
