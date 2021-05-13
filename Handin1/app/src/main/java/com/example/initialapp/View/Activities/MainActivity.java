package com.example.initialapp.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.initialapp.Adapter.IdeaAdapter;
import com.example.initialapp.Adapter.SectionsPagerAdapter;
import com.example.initialapp.R;
import com.example.initialapp.View.Fragments.CreateFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements IdeaAdapter.OnListIdeaClickListener {

    private TabItem allTabItem;
    private TabItem wishlistTabItem;
    private TabItem completedTabItem;
    private TabLayout tabs;
    private ViewPager viewPager;
    private FloatingActionButton fab;

    // for the bucket list recyclerview
    RecyclerView mIdeaList;
    IdeaAdapter mIdeaAdapter;

    private View mainView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        // floating action button (+) navigates to Create Fragment
        fab.setOnClickListener(view -> onClick(mainView)); //TODO it shows nullpointerexception

        // for changing between tabs
        viewPager.setAdapter(sectionsPagerAdapter); //TODO it shows nullpointerexception
        tabs.setupWithViewPager(viewPager);

        initializeFragmentsValues();

        mIdeaList.hasFixedSize();
        mIdeaList.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initializeFragmentsValues() {
        tabs = mainView.findViewById(R.id.tabLayout);
        viewPager = mainView.findViewById(R.id.view_pager);
        fab = mainView.findViewById(R.id.fab);
    }

    @Override
    public void onListIdeaClick(int clickedIdeaIndex) {

    }

    public void onClick(View view) {
        startActivity(new Intent(this, CreateFragment.class));
        finish();
    }
}
