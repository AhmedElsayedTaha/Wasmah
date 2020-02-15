package com.example.wasmah.Adapters;

import android.content.Context;

import com.example.wasmah.Fragments.JKRFragment;
import com.example.wasmah.Fragments.MapFragment;
import com.example.wasmah.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior,Context context) {
        super(fm, behavior);
        this.context = context;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new MapFragment();
        }
        else {
            return new JKRFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       if(position==0){
           return context.getString(R.string.map);
       }
       else
           return context.getString(R.string.repo);
    }
}
