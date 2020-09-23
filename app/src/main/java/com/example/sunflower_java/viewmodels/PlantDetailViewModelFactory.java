package com.example.sunflower_java.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.sunflower_java.data.GardenPlantingRepository;
import com.example.sunflower_java.data.PlantRepository;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/23
 * @version: 1.1.0
 */
public class PlantDetailViewModelFactory implements ViewModelProvider.Factory {
    private PlantRepository plantRepository;
    private GardenPlantingRepository gardenPlantingRepository;
    private String plantId;

    public PlantDetailViewModelFactory(PlantRepository plantRepository, GardenPlantingRepository gardenPlantingRepository, String plantId) {
        this.plantRepository = plantRepository;
        this.gardenPlantingRepository = gardenPlantingRepository;
        this.plantId = plantId;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PlantDetailViewModel(plantRepository,gardenPlantingRepository,plantId);
    }
}
