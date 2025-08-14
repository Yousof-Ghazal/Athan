package com.yousof.athan.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meta")
data class MetaEntity(
    @PrimaryKey val locationKey: String,
    val timezoneId: String,
    val method: String,
    val lastFullSyncEpochSec: Long,
)
