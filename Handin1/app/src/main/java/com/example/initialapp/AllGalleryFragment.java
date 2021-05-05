package com.example.initialapp;

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

public class AllGalleryFragment extends Fragment {

    private EditText emailText;
    private EditText passText;
    private Button loginButton;
    private TextView info;
    private int counter = 5;
    private View loginView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginView = inflater.inflate(R.layout.fragment_allgallery,container,false);
        initializeFragmentsValues();
        loginButton.setOnClickListener(view -> {
            Navigation.findNavController(loginView).navigate(R.id.action_allGalleryFragment_to_galleryFragment);
        });

        return loginView;
    }

    private void initializeFragmentsValues() {
        loginButton= loginView.findViewById(R.id.loginButton);
        emailText = loginView.findViewById(R.id.editTextEmailAddress);
        passText = loginView.findViewById(R.id.editTextPassword);
        info = loginView.findViewById(R.id.errorTextView);

    }
}
