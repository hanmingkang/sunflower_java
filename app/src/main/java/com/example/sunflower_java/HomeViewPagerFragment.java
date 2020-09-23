package com.example.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.sunflower_java.adapter.SunflowerPagerAdapter;
import com.example.sunflower_java.databinding.FragmentViewPagerBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/21
 * @version: 1.1.0
 */
public class HomeViewPagerFragment extends Fragment {
    private final static int MY_GARDEN_PAGE_INDEX = 0;
    private final static int PLANT_LIST_PAGE_INDEX = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentViewPagerBinding binding = FragmentViewPagerBinding.inflate(inflater,container,false);
        TabLayout tableLayout = binding.tabs;
        ViewPager2 viewPager2 = binding.viewPager;

        viewPager2.setAdapter(new SunflowerPagerAdapter(this));

        new TabLayoutMediator(tableLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setIcon(getTabIcon(position));
                tab.setText(getTabTitle(position));
            }
        }).attach();
        return binding.getRoot();
    }

    private String getTabTitle(int position) {
        switch (position){
            case MY_GARDEN_PAGE_INDEX:
                return getString(R.string.my_garden_title);
            case PLANT_LIST_PAGE_INDEX:
                return getString(R.string.plant_list_title);
            default:break;
        }
        throw new IndexOutOfBoundsException();
    }

    private int getTabIcon(int position) {
        switch (position){
            case MY_GARDEN_PAGE_INDEX:
                return R.drawable.garden_tab_selector;
            case PLANT_LIST_PAGE_INDEX:
                return R.drawable.plant_list_tab_selector;
            default:break;
        }
        throw new IndexOutOfBoundsException();
    }
}
