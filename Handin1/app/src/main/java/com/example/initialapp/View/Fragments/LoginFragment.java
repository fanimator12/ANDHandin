package com.example.initialapp.View.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.initialapp.R;
import com.example.initialapp.Viewmodel.LoginViewModel;

public class LoginFragment extends Fragment {
    EditText emailText;
    EditText passText;
    Button loginButton;
    TextView info;
    private View loginView;
    private int counter = 5;

    private LoginViewModel loginViewModel;

    private static final String TAG = "LoginFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate was called");
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginView = inflater.inflate(R.layout.fragment_login, container, false);
        initializeFragmentsValues();
        loginButton.setOnClickListener(view -> {
            Navigation.findNavController(loginView).navigate(R.id.action_loginFragment_to_allGalleryFragment);
        });

        return loginView;
    }

    private void initializeFragmentsValues() {
        loginButton = loginView.findViewById(R.id.loginButton);
        emailText = loginView.findViewById(R.id.editTextEmailAddress);
        passText = loginView.findViewById(R.id.editTextPassword);
        info = loginView.findViewById(R.id.errorTextView);
    }

}