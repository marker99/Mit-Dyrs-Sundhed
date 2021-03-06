package com.github.marker99.persistence;

import androidx.room.TypeConverter;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//Hugget fra https://developer.android.com/training/data-storage/room/referencing-data

public class DateHandler {

    public static String fromLongToString(long ms){
        Date date = new Date(ms);
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM-yyyy");
        return dateFormat.format(date);
    }

    public static MaterialDatePicker getMaterialDatePicker(){
        //Material Design
        //https://material.io/components/date-pickers/android#using-date-pickers

        //Setting calenderConstraints, so you can scroll to month after current!
        CalendarConstraints.Builder calenderConstraint = new CalendarConstraints.Builder();
        calenderConstraint.setEnd(MaterialDatePicker.todayInUtcMilliseconds());

        //Setting calenderConstraint validator, so a date beyond current date cannot be chosen!
        CalendarConstraints.DateValidator dateValidatorMax = DateValidatorPointBackward.before(MaterialDatePicker.todayInUtcMilliseconds());
        calenderConstraint.setValidator(dateValidatorMax);

        MaterialDatePicker materialDatePicker =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select date")
                        .setCalendarConstraints(calenderConstraint.build())
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
                        .build();

        return materialDatePicker;
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
