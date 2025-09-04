package com.yousof.athan.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PrayerApi {
    // Aladhan: /v1/calendarByCity/{year}/{month}?city=…&country=…&method=…
    @GET("v1/calendarByCity/{year}/{month}")
    suspend fun getMonthlyByCity(
        @Path("year") year: Int,
        @Path("month") month: Int,
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: String,
    ): AladhanMonthResponse

    @GET("calendar")
    suspend fun getMonthlyByCoords(
        @Query("latitude") lat: Double,
        @Query("longitude") lng: Double,
        @Query("method") method: String,
        @Query("month") month: Int,
        @Query("year") year: Int,
    ): AladhanMonthResponse
}

// Minimaler DTO für die Aladhan-Struktur
data class AladhanMonthResponse(
    val code: Int,
    val status: String,
    val data: List<AladhanDay>,
)

data class AladhanDay(
    val date: AladhanDate,
    val timings: AladhanTimings,
)

data class AladhanDate(
    val readable: String?,
    val gregorian: AladhanGregorian,
)

data class AladhanGregorian(val date: String)

data class AladhanTimings(
    val Fajr: String,
    val Dhuhr: String,
    val Asr: String,
    val Maghrib: String,
    val Isha: String,
    val Sunrise: String? = null,
)
