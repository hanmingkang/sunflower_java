package com.example.sunflower_java.utilities;

import android.content.Context;

import com.example.sunflower_java.data.AppDataBase;
import com.example.sunflower_java.data.GardenPlantingRepository;
import com.example.sunflower_java.data.PlantRepository;
import com.example.sunflower_java.viewmodels.PlantDetailViewModelFactory;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/22
 * @version: 1.1.0
 */
public class InjectorUtils {

    private static PlantRepository getPlantRepository(Context context){
        return PlantRepository.getInstance(AppDataBase.getInstance(context).plantDao());
    }

    private static GardenPlantingRepository getGardenPlantingRepository(Context context){
        return GardenPlantingRepository.getInstance(AppDataBase.getInstance(context).gardenPlantingDao());
    }

    public static PlantDetailViewModelFactory providePlantDetailViewModelFactory(Context context,String plantId){
        return new PlantDetailViewModelFactory(getPlantRepository(context),getGardenPlantingRepository(context),plantId);
    }

}
