package com.example.sunflower_java.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sunflower_java.BuildConfig;
import com.example.sunflower_java.data.GardenPlantingRepository;
import com.example.sunflower_java.data.Plant;
import com.example.sunflower_java.data.PlantRepository;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/22
 * @version: 1.1.0
 */
public class PlantDetailViewModel extends ViewModel {
    public LiveData<Plant> plant;
    public LiveData<Boolean> isPlanted;
    public PlantRepository plantRepository;
    public GardenPlantingRepository gardenPlantingRepository;
    public String plantId;

    public PlantDetailViewModel(PlantRepository plantRepository, GardenPlantingRepository gardenPlantingRepository,String plantId) {
        isPlanted = gardenPlantingRepository.isPlanted(plantId);
        plant = plantRepository.getPlant(plantId);
        this.plantId = plantId;
        this.plantRepository = plantRepository;
        this.gardenPlantingRepository = gardenPlantingRepository;
    }

    public void addPlantToGarden(){
        gardenPlantingRepository.createGardenPlanting(plantId);
    }

    public boolean hasValidUnsplashKey(){
        return BuildConfig.UNSPLASH_ACCESS_KEY != "null";
    }
}
