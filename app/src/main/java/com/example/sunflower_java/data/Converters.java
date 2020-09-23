package com.example.sunflower_java.data;

import android.view.animation.ScaleAnimation;

import androidx.room.TypeConverter;

import java.util.Calendar;

/**
 * @description:
 * @author: kangsx
 * @date: 2020/9/22
 * @version: 1.1.0
 */
public class Converters {
    @TypeConverter
    public static long calendarToDatestamp(Calendar calendar){
        return calendar.getTimeInMillis();
    }

    @TypeConverter
    public static Calendar datestampToCalendar(long value){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(value);
        return calendar;
    }
}
