package com.example.initialapp.UI.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.initialapp.Database.BucketListGoals;
import com.example.initialapp.Database.Repository.IBucketListRepository;
import com.example.initialapp.R;
import com.example.initialapp.UI.Viewmodel.CreateViewModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class CreateActivity extends AppCompatActivity {

    private TextView createTextView, activityTextView, locationTextView, typeTextView, pictureTextView;
    private EditText nameActivity, addLocation;
    private ImageButton imageButton;
    private Button addToWishListButton;
    private Spinner typeSpinner;

    InputMethodManager methodManager;

    private static final String TAG = "CreateActivity";

//    private CreateViewModel createViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

//        createViewModel = new ViewModelProvider(this).get(CreateViewModel.class);

        createTextView = findViewById(R.id.createTextView);
        activityTextView = findViewById(R.id.activityTextView);
        locationTextView = findViewById(R.id.locationTextView);
        pictureTextView = findViewById(R.id.pictureTextView);
        typeTextView = findViewById(R.id.typeTextView);

        nameActivity = findViewById(R.id.nameActivityHint);
        addLocation = findViewById(R.id.addLocationHint);

        imageButton = findViewById(R.id.imageButton);
        addToWishListButton = findViewById(R.id.addToWishListButton);

        typeSpinner = findViewById(R.id.typeSpinner);

        //Used for loading panel
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);

        //Used to closed the keyboard after input
        methodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

//        createViewModel.getBucketlist(nameActivity.toString(), addLocation.toString(), typeSpinner.toString(), imageButton.getId()).observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                try {
//                    typeTextView.setText(s);
//                    createViewModel.insert(new BucketListGoals(FirebaseAuth.getInstance().getCurrentUser().getEmail(), createViewModel.NEW_BUCKETLIST, addLocation.getText().toString(), typeSpinner.getSelectedItem().toString(), imageButton.getId());
//
//                }
//                catch(Exception e){
//                    e.printStackTrace();
//                }
//                nameActivity.getText().clear();
//                addLocation.getText().clear();
//                findViewById(R.id.loadingPanel).setVisibility(View.INVISIBLE);
//            }
//        });

        //Used to add new bucketlist to user's wishlist
        addToWishListButton.setOnClickListener(this::saveBucketlist);

        Log.d(TAG, "onCreate was called");
    }

    public void saveBucketlist(View v) {
        methodManager.hideSoftInputFromWindow(nameActivity.getWindowToken(), 0);
        methodManager.hideSoftInputFromWindow(addLocation.getWindowToken(), 1);

        findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);

        try{
            String activity = nameActivity.getText().toString();
            String location = addLocation.getText().toString();
            String type = typeSpinner.getSelectedItem().toString();
            Integer image = imageButton.getId();

            if (activity.trim().isEmpty() || type.isEmpty()){
                Toast.makeText(this,"Please insert activity and type", Toast.LENGTH_LONG).show();
                return;
            }

//            createViewModel.getBucketlist(activity, location, type, image);
//            createViewModel.fetchData();

            setResult(RESULT_OK);
            finish();
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this,"Input values",Toast.LENGTH_SHORT).show();
            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        }
    }
}
