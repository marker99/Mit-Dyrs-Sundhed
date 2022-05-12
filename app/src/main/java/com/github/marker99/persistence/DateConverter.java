package com.github.marker99.persistence;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

//Hugget fra https://developer.android.com/training/data-storage/room/referencing-data

public class DateConverter {
    public static Date fromSecondsToDate(long ms){
        return new Date(ms);
    }

    public static String fromLongToString(long ms){
        Date date = new Date(ms);
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM-yyyy");
        return dateFormat.format(date);
    }

    //TODO: Skal bruges til at sorterer i recycleview!
    public static String fromStringToLong(String date){
        return null;
    }

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
