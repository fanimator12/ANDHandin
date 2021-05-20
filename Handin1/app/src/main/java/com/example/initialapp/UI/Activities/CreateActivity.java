package com.example.initialapp.UI.Activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.initialapp.Database.BucketListGoals;
import com.example.initialapp.R;
import com.example.initialapp.UI.Viewmodel.CreateViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class CreateActivity extends AppCompatActivity {

    private TextView createTextView, activityTextView;
    private EditText nameActivity;
    private Button addToWishListButton;

    InputMethodManager methodManager;

    private static final String TAG = "CreateActivity";

    private CreateViewModel createViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createTextView = findViewById(R.id.createTextView);
        activityTextView = findViewById(R.id.activityTextView);
        nameActivity = findViewById(R.id.nameActivityHint);
        addToWishListButton = findViewById(R.id.addToWishListButton);

        createViewModel = new ViewModelProvider(this).get(CreateViewModel.class);

        //Used for loading panel
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);

        //Used to closed the keyboard after input
        methodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            createViewModel.getBucketlistItem().observe(this, new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    try {
                        nameActivity.setText(s);
                        createViewModel.insert(new BucketListGoals(FirebaseAuth.getInstance().getCurrentUser().getEmail(), createViewModel.NEW_BUCKETLIST_ITEM));

                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    nameActivity.getText().clear();
                    findViewById(R.id.loadingPanel).setVisibility(View.INVISIBLE);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
            findViewById(R.id.loadingPanel).setVisibility(View.INVISIBLE);
        }

        //Used to add new bucketlist to user's wishlist
        addToWishListButton.setOnClickListener(this::saveBucketlist);

        Log.d(TAG, "onCreate was called");
    }

    public void saveBucketlist(View v) {
        methodManager.hideSoftInputFromWindow(nameActivity.getWindowToken(), 0);

        findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);

        try{
            String activity = nameActivity.getText().toString();


            if (activity.trim().isEmpty()){
                Toast.makeText(this,"Please insert activity", Toast.LENGTH_LONG).show();
                return;
            }

            createViewModel.postBucketlistItem();
            createViewModel.fetchData();

            setResult(RESULT_OK);
            finish();
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        }
    }
}
