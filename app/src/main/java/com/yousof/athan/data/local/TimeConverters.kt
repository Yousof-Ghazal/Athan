package com.yousof.athan.data.local

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalTime

class TimeConverters {
    // Von DB nach Objekt
    @TypeConverter
    fun fromDate(value: String?): LocalDate? = value?.let { LocalDate.parse(it) }

    // LocalDate.of(2025, 8, 14) → "2025-08-14" (ISO-Format).
    @TypeConverter
    fun dateToString(date: LocalDate?): String? = date?.toString()

    // "04:18" → LocalTime.of(4, 18)
    @TypeConverter
    fun fromTime(value: String?): LocalTime? = value?.let { LocalTime.parse(it) }

    // LocalTime.of(4, 18) → "04:18".
    @TypeConverter
    fun timeToString(time: LocalTime?): String? = time?.toString()
}
