package com.example.initialapp.UI.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.initialapp.R;
import com.example.initialapp.UI.Viewmodel.FrontPageViewModel;

import java.io.InputStream;

public class FrontPageFragment extends Fragment {

    private FrontPageViewModel frontPageViewModel;
    View frontPageView;

    private int progress = 50;
    private ProgressBar progressBar;

    private static final String TAG = "FrontPageFragment";

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        frontPageViewModel = new ViewModelProvider(this).get(FrontPageViewModel.class);
        View frontPageView = inflater.inflate(R.layout.fragment_frontpage, container, false);

        InputStream is = getResources().openRawResource(R.raw.travel_animation);
        progressBar = frontPageView.findViewById(R.id.progressBar);
        setUpObserver();
        updateProgressBar();
        Log.d(TAG, "onCreate was called");

        return frontPageView;
    }


    // TODO does not work yet
    @SuppressLint("DefaultLocale")
    private void updateProgressBar(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    frontPageViewModel.fetchData();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        });
        thread.start();
    }

    private void setUpObserver(){
        frontPageViewModel.getCompletedGoals().observe(this, overallProgress -> {
            int progressDigit = (int)Double.parseDouble(overallProgress);
            progressBar.setProgress(progressDigit);
        });
    }
}
