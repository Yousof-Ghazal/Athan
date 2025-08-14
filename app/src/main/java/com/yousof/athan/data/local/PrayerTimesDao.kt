package com.yousof.athan.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.time.LocalDate

@Dao
interface PrayerTimesDao {
    // Holt alle Gebetszeiten zwischen zwei Daten für einen Ort
    @Query(
        """
          SELECT * FROM prayer_times
        WHERE locationKey = :loc 
          AND date BETWEEN :from AND :to
        ORDER BY date ASC
    """,
    )
    suspend fun getRange(
        loc: String,
        from: LocalDate,
        to: LocalDate,
    ): List<PrayerTimeEntity>

    // Holt eine bestimmte Tages-Zeile
    @Query(
        """
        SELECT * FROM prayer_times
        WHERE locationKey = :loc 
          AND date = :date
        LIMIT 1
    """,
    )
    suspend fun getByDate(
        loc: String,
        date: LocalDate,
    ): PrayerTimeEntity?

    // Fügt mehrere Zeilen ein oder ersetzt sie, wenn es Konflikte gibt
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<PrayerTimeEntity>)
}
