package com.yousof.athan.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface PrayerTimesDao {
    // Holt alle Gebetszeiten zwischen zwei Daten für einen Ort

    // Holt eine bestimmte Tages-Zeile

    // Fügt mehrere Zeilen ein oder ersetzt sie, wenn es Konflikte gibt
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<PrayerTimeEntity>)
}
