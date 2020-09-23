package com.example.sunflower_java.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.sunflower_java.utilities.Constants;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/22
 * @version: 1.1.0
 */
@Database(entities = {Plant.class,GardenPlanting.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDataBase extends RoomDatabase {
    public abstract GardenPlantingDao gardenPlantingDao();
    public abstract PlantDao plantDao();

    private static volatile AppDataBase instance = null;

    public static AppDataBase getInstance(Context context){
        if(instance == null){
            synchronized (AppDataBase.class){
                if(instance == null){
                    instance = Room.databaseBuilder(context,AppDataBase.class, Constants.DATABASE_NAME).addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                        }
                    }).build();
                }
            }
        }
        return instance;
    }
}
