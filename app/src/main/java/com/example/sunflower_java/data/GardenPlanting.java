package com.example.sunflower_java.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Calendar;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/22
 * @version: 1.1.0
 */
@Entity(tableName = "garden_plantings",
        foreignKeys = @ForeignKey(
                entity = Plant.class,
                parentColumns = "id",
                childColumns = "plant_id"),
        indices = {@Index("plant_id")})
public class GardenPlanting {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private long gardenPlantingId;
    @ColumnInfo(name = "plant_id")
    private String plantId;
    @ColumnInfo(name = "plant_date")
    private Calendar plantDate;
    @ColumnInfo(name = "last_watering_date")
    private Calendar lastWateringDate;

    public GardenPlanting(String plantId) {
        this.plantId = plantId;
        plantDate = Calendar.getInstance();
        lastWateringDate = Calendar.getInstance();
    }

    public long getGardenPlantingId() {
        return gardenPlantingId;
    }

    public void setGardenPlantingId(long gardenPlantingId) {
        this.gardenPlantingId = gardenPlantingId;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public Calendar getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(Calendar plantDate) {
        this.plantDate = plantDate;
    }

    public Calendar getLastWateringDate() {
        return lastWateringDate;
    }

    public void setLastWateringDate(Calendar lastWateringDate) {
        this.lastWateringDate = lastWateringDate;
    }
}
