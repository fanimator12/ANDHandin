package com.example.initialapp.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.initialapp.UI.Fragments.AllGalleryFragment;
import com.example.initialapp.UI.Fragments.CompletedGalleryFragment;
import com.example.initialapp.UI.Fragments.WishlistGalleryFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       Fragment fragment = null;
       switch (position) {
           case 0:
               fragment = new AllGalleryFragment();
               break;
           case 1:
               fragment = new WishlistGalleryFragment();
               break;
           case 2:
               fragment = new CompletedGalleryFragment();
       }
       return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "All";
            case 1:
                return "Wishlist";
            case 2:
                return "Completed";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}
