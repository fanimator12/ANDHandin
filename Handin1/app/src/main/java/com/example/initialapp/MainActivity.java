package com.example.initialapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailText;
    EditText passText;
    Button loginButton;
    TextView info;
    private View loginView;
    private int counter = 5;
    static final String ALL_GALLERY = "com.example.initialapp.ALL_GALLERY";

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.textView);
        emailText = findViewById(R.id.editTextEmailAddress);
        passText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.loginButton);

        Log.d(TAG, "onCreate was called");

        loginButton.setOnClickListener(view -> onClick(info));

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey(ALL_GALLERY)) {
            String message = bundle.getString(ALL_GALLERY);
            info.setText(message);
        }
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view){
        validate(emailText.getText().toString(), passText.getText().toString());

        Context context = getApplicationContext();
        String text = "Logging in...";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
    }

    @SuppressLint("SetTextI18n")
    private void validate(String email, String password){
        if((email.equals("user@email.com")) && (password.equals("AND"))){ //TODO, must change
            Intent intent = new Intent(MainActivity.this, AllGalleryFragment.class);
            startActivity(intent);
        } else {
            counter--;

            info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                loginButton.setEnabled(false);
            }
        }
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginView = inflater.inflate(R.layout.activity_main,container,false);
        initializeFragmentsValues();
        loginButton.setOnClickListener(view -> {
            Navigation.findNavController(loginView).navigate(R.id.action_mainActivity_to_allGalleryFragment);
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