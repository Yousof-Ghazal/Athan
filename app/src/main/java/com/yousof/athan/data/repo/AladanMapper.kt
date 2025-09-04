package com.yousof.athan.data.repo

import com.yousof.athan.data.remote.AladhanMonthResponse
import com.yousof.athan.data.remote.PrayerTimeDto

internal fun AladhanMonthResponse.toDtos(): List<PrayerTimeDto> {
    return data.map { day ->
        PrayerTimeDto(
            date = day.date.gregorian.date,
            fajr = day.timings.Fajr,
            dhuhr = day.timings.Dhuhr,
            asr = day.timings.Asr,
            maghrib = day.timings.Maghrib,
            isha = day.timings.Isha,
        )
    }
}
