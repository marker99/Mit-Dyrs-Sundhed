package com.github.marker99.persistence;

import androidx.room.TypeConverter;

import java.util.Date;

//Hugget fra https://developer.android.com/training/data-storage/room/referencing-data

public class DateConverter {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
