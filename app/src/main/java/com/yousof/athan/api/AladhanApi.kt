package com.yousof.athan.api

import retrofit2.http.GET
import retrofit2.http.Query

const val MUSLIM_WORLD_LEAGUE_METHOD_CALCULATION: Int = 3

interface AladhanApi {
    @GET("timingsByCity")
    suspend fun getPrayerTimes(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Int = MUSLIM_WORLD_LEAGUE_METHOD_CALCULATION,
    ): Aladan
}
