package com.yousof.athan.data.local

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    @Volatile
    private var instance: AppDatabase? = null

    fun get(context: Context): AppDatabase {
        return instance ?: synchronized(this) {
            instance ?: build(context).also { instance = it }
        }
    }

    private fun build(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "Athan2.db",
        )
            // ACHTUNG: nur während der Entwicklung ok.
            // Später durch echte Migrationen ersetzen!
            .fallbackToDestructiveMigration()
            .build()
    }
}
