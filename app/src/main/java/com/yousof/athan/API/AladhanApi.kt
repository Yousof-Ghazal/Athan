package com.yousof.athan.API

import retrofit2.http.GET
import retrofit2.http.Query

interface AladhanApi {

    @GET("timingsByCity")
    suspend fun getPrayerTimes(
        @Query ("city") city: String,
        @Query ("country") country: String,
        @Query ("method") method: Int = 3
    ) : Aladan
}