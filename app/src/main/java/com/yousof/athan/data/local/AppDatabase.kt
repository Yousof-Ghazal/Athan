package com.yousof.athan.data.local

import PrayerTimesDao
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

// Database sagt Room, welche Tabellen es gibt und welche Version das Schema hat.
// Eine zentrale AppDatabase‑Klasse, die Room kennt.
// Da registrieren wir die Converter und listen alle Entities auf.
@Database(
    entities = [PrayerTimeEntity::class, MetaEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(TimeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun prayerDao(): PrayerTimesDao

    abstract fun metaDao(): MetaDao
}
