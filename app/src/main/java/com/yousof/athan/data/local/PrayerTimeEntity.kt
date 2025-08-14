package com.yousof.athan.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.yousof.athan.api.Aladan
import java.time.LocalTime

@Entity(
    tableName = "prayer_times",
    indices = [Index(value = ["date", "locationKey"], unique = true)],
)
data class PrayerTimeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: Aladan.Data.Date,
    val fajr: LocalTime,
    val dhuhr: LocalTime,
    val asr: LocalTime,
    val maghrib: LocalTime,
    val isha: LocalTime,
    val locationKey: String,
    val calcMethod: String,
    val lastUpdatedEpochSec: Long,
)
