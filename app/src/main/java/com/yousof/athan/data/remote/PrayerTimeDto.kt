package com.yousof.athan.data.remote

/**
 * Schablone für "Monatliche Gebetszeiten".
 * Passe die Felder an deine echte API an (z.B. "fajr" vs "Fajr", "date" Format, etc.).
 */

data class PrayerTimeDto(
    val date: String,
    val fajr: String,
    val dhuhr: String,
    val asr: String,
    val maghrib: String,
    val isha: String,
)
