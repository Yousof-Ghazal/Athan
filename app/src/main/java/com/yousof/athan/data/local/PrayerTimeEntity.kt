package com.yousof.athan.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "prayer_times",
)
data class PrayerTimeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: String,
    val fajr: String,
    val dhuhr: String,
    val asr: String,
    val maghrib: String,
    val isha: String,
//    val locationKey: String,
//    val calcMethod: String,
//    val lastUpdatedEpochSec: Long,
)
