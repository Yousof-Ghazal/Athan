package com.yousof.athan.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MetaDao {
    // eine kleine Tabelle pro Standort/Methoden-Kombi.

    @Query("SELECT * FROM meta WHERE locationKey = :loc LIMIT 1")
    suspend fun get(loc: String): MetaEntity?

    // Metadaten holen (get)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(meta: MetaEntity)

    // Neue Metadaten setzen/überschreiben (upsert)
}
