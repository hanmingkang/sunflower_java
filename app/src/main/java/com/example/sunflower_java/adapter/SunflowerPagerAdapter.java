package com.example.sunflower_java.adapter;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.sunflower_java.GardenFragment;
import com.example.sunflower_java.PlantListFragment;

import java.util.Objects;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/21
 * @version: 1.1.0
 */
public class SunflowerPagerAdapter extends FragmentStateAdapter {

    private final static int MY_GARDEN_PAGE_INDEX = 0;
    private final static int PLANT_LIST_PAGE_INDEX = 1;

    public SunflowerPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case MY_GARDEN_PAGE_INDEX:
                return new GardenFragment();
            case PLANT_LIST_PAGE_INDEX:
                return new PlantListFragment();
            default:
                break;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
