package com.example.initialapp.UI.Activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.initialapp.R;

public class CreateActivity extends AppCompatActivity {
    private TextView createTextView, activityTextView, locationTextView, typeTextView, pictureTextView;
    private EditText nameActivity, addLocation;
    private ImageButton imageButton;
    private Button addToWishListButton;
    private Spinner spinner;

    InputMethodManager methodManager;

    private static final String TAG = "CreateActivity";

    private static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

//        initializeValues();
        createTextView = findViewById(R.id.createTextView);
        activityTextView = findViewById(R.id.activityTextView);
        locationTextView = findViewById(R.id.locationTextView);
        pictureTextView = findViewById(R.id.pictureTextView);
        typeTextView = findViewById(R.id.typeTextView);

        nameActivity = findViewById(R.id.nameActivityHint);
        addLocation = findViewById(R.id.addLocationHint);

        imageButton = findViewById(R.id.imageButton);
        addToWishListButton = findViewById(R.id.addToWishListButton);

        spinner = findViewById(R.id.spinner);

        //Used for loading panel
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
//        setUpObserver();

        //Used to closed the keyboard after input
        methodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        Log.d(TAG, "onCreate was called");
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
