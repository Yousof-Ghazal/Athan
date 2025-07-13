package com.yousof.athan.API

data class Aladan(
    val code: Int,
    val `data`: Data,
    val status: String
) {
    data class Data(
        val date: Date,
        val meta: Meta,
        val timings: Timings
    ) {
        data class Date(
            val gregorian: Gregorian,
            val hijri: Hijri,
            val readable: String,
            val timestamp: String
        ) {
            data class Gregorian(
                val date: String,
                val day: String,
                val designation: Designation,
                val format: String,
                val lunarSighting: Boolean,
                val month: Month,
                val weekday: Weekday,
                val year: String
            ) {
                data class Designation(
                    val abbreviated: String,
                    val expanded: String
                )

                data class Month(
                    val en: String,
                    val number: Int
                )

                data class Weekday(
                    val en: String
                )
            }

            data class Hijri(
                val adjustedHolidays: List<Any>,
                val date: String,
                val day: String,
                val designation: Designation,
                val format: String,
                val holidays: List<String>,
                val method: String,
                val month: Month,
                val weekday: Weekday,
                val year: String
            ) {
                data class Designation(
                    val abbreviated: String,
                    val expanded: String
                )

                data class Month(
                    val ar: String,
                    val days: Int,
                    val en: String,
                    val number: Int
                )

                data class Weekday(
                    val ar: String,
                    val en: String
                )
            }
        }

        data class Meta(
            val latitude: Double,
            val latitudeAdjustmentMethod: String,
            val longitude: Double,
            val method: Method,
            val midnightMode: String,
            val offset: Offset,
            val school: String,
            val timezone: String
        ) {
            data class Method(
                val id: Int,
                val location: Location,
                val name: String,
                val params: Params
            ) {
                data class Location(
                    val latitude: Double,
                    val longitude: Double
                )

                data class Params(
                    val Fajr: Int,
                    val Isha: Int
                )
            }

            data class Offset(
                val Asr: Int,
                val Dhuhr: Int,
                val Fajr: Int,
                val Imsak: Int,
                val Isha: Int,
                val Maghrib: Int,
                val Midnight: Int,
                val Sunrise: Int,
                val Sunset: Int
            )
        }

        data class Timings(
            val Asr: String,
            val Dhuhr: String,
            val Fajr: String,
            val Firstthird: String,
            val Imsak: String,
            val Isha: String,
            val Lastthird: String,
            val Maghrib: String,
            val Midnight: String,
            val Sunrise: String,
            val Sunset: String
        )
    }
}