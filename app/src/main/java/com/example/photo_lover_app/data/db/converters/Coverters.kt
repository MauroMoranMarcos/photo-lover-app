package com.example.photo_lover_app.data.db.converters

import androidx.room.TypeConverter
import java.util.Date

class Coverters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? = value?.let {Date(it)}

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time

}