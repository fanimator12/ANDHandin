package com.example.initialapp.UI.Activities;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.initialapp.R;
import com.example.initialapp.UI.Viewmodel.DescriptionViewModel;

public class DescriptionActivity extends AppCompatActivity {
    private Button removeFromWishListButton;
    private TextView title;
    private ImageView image;
    private TextView location;
    private TextView type;
    private CheckBox checkbox;

    private DescriptionViewModel descriptionViewModel;

    private static final String TAG = "DescriptionActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        descriptionViewModel = new ViewModelProvider(this).get(DescriptionViewModel.class);

        removeFromWishListButton = findViewById(R.id.removeButton);
        title = findViewById(R.id.goal_title);
        image = findViewById(R.id.imageView);
        location = findViewById(R.id.location);
        type = findViewById(R.id.type);
        checkbox = findViewById(R.id.checkBox);

        Log.d(TAG, "onCreate was called");
    }
}
