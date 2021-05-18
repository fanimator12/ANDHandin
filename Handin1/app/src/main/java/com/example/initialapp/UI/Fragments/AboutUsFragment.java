package com.example.initialapp.UI.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.initialapp.R;
import com.example.initialapp.UI.Viewmodel.AboutUsViewModel;

public class AboutUsFragment extends Fragment {
    private AboutUsViewModel aboutUsViewModel;
    View aboutUsView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        aboutUsViewModel = new ViewModelProvider(this).get(AboutUsViewModel.class);
        View aboutUsView = inflater.inflate(R.layout.fragment_about_us, container, false);

        Button button_icons = aboutUsView.findViewById(R.id.icons_button);

        button_icons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ladybbucketlist.docs.apiary.io/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return aboutUsView;
    }
}
