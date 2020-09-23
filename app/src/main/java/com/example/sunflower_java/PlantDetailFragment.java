package com.example.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sunflower_java.data.Plant;
import com.example.sunflower_java.databinding.FragmentPlantDetailBinding;
import com.example.sunflower_java.utilities.InjectorUtils;
import com.example.sunflower_java.viewmodels.PlantDetailViewModel;
import com.example.sunflower_java.viewmodels.PlantDetailViewModelFactory;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/21
 * @version: 1.1.0
 */
public class PlantDetailFragment extends Fragment {
    private FragmentPlantDetailBinding binding;
    private PlantDetailViewModel plantDetailViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_plant_detail, container, false);
        PlantDetailFragmentArgs args;
        args = PlantDetailFragmentArgs.fromBundle(getArguments());
        PlantDetailViewModelFactory plantDetailViewModelFactory = InjectorUtils.providePlantDetailViewModelFactory(getActivity(), args.getPlantId());
        plantDetailViewModel = new ViewModelProvider(requireActivity(),plantDetailViewModelFactory).get(PlantDetailViewModel.class);
        binding.setViewModel(plantDetailViewModel);
        return binding.getRoot();
    }
}
