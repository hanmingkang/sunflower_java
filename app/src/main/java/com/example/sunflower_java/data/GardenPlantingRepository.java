package com.example.sunflower_java.data;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/22
 * @version: 1.1.0
 */
public class GardenPlantingRepository {
    private GardenPlantingRepository(GardenPlantingDao gardenPlantingDao) {
        this.gardenPlantingDao = gardenPlantingDao;
    }
    private static volatile GardenPlantingRepository instance;
    private GardenPlantingDao gardenPlantingDao;

    public static GardenPlantingRepository getInstance(GardenPlantingDao gardenPlantingDao){
        if(instance == null){
            synchronized (GardenPlantingRepository.class){
                if(instance == null){
                    instance = new GardenPlantingRepository(gardenPlantingDao);
                }
            }
        }
        return instance;
    }

    public void createGardenPlanting(String plantId){
        GardenPlanting gardenPlanting = new GardenPlanting(plantId);
        gardenPlantingDao.insertGardenPlanting(gardenPlanting);
    }

    public LiveData<Boolean> isPlanted(String plantId){
        return gardenPlantingDao.isPlanted(plantId);
    }

    public LiveData<List<PlantAndGardenPlantings>> getPlantedGardens(){
        return gardenPlantingDao.getPlantedGardens();
    }
}
