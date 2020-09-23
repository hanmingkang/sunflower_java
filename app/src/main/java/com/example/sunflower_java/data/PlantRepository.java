package com.example.sunflower_java.data;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/22
 * @version: 1.1.0
 */
public class PlantRepository {
    private PlantRepository(PlantDao plantDao){
        this.plantDao = plantDao;
    }
    private PlantDao plantDao;
    private static volatile PlantRepository instance;

    public static PlantRepository getInstance(PlantDao plantDao){
        if(instance == null){
            synchronized (PlantRepository.class){
                if(instance == null){
                    instance = new PlantRepository(plantDao);
                }
            }
        }
        return instance;
    }

    public LiveData<List<Plant>> getPlants(){
        return plantDao.getPlants();
    }

    public LiveData<Plant> getPlant(String plantId){
        return plantDao.getPlant(plantId);
    }

    public LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int growZoneNumber){
        return plantDao.getPlantsWithGrowZoneNumber(growZoneNumber);
    }
}
