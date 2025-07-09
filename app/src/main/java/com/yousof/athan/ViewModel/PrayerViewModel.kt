package com.yousof.athan.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yousof.athan.API.Aladan
import com.yousof.athan.API.AladhanApi
import com.yousof.athan.API.RetrofitObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PrayerViewModel : ViewModel() {
    private val aladhanApi = RetrofitObject.aladanApi
    val uiState = MutableStateFlow(Aladan(
        code = 0, data = Aladan.Data(
            date = Aladan.Data.Date(
                gregorian = Aladan.Data.Date.Gregorian(
                    date = "",
                    day = "",
                    designation = Aladan.Data.Date.Gregorian.Designation(
                        abbreviated = "",
                        expanded = ""
                    ),
                    format = "",
                    lunarSighting = false,
                    month = Aladan.Data.Date.Gregorian.Month(en = "", number = 0),
                    weekday = Aladan.Data.Date.Gregorian.Weekday(en = ""),
                    year = ""
                ), hijri = Aladan.Data.Date.Hijri(
                    adjustedHolidays = listOf(),
                    date = "",
                    day = "",
                    designation = Aladan.Data.Date.Hijri.Designation(
                        abbreviated = "",
                        expanded = ""
                    ),
                    format = "",
                    holidays = listOf(),
                    method = "",
                    month = Aladan.Data.Date.Hijri.Month(
                        ar = "",
                        days = 0,
                        en = "",
                        number = 0
                    ),
                    weekday = Aladan.Data.Date.Hijri.Weekday(ar = "", en = ""),
                    year = ""
                ), readable = "", timestamp = ""
            ), meta = Aladan.Data.Meta(
                latitude = 0.0,
                latitudeAdjustmentMethod = "",
                longitude = 0.0,
                method = Aladan.Data.Meta.Method(
                    id = 0,
                    location = Aladan.Data.Meta.Method.Location(
                        latitude = 0.0,
                        longitude = 0.0
                    ),
                    name = "",
                    params = Aladan.Data.Meta.Method.Params(Fajr = 0, Isha = 0)
                ),
                midnightMode = "",
                offset = Aladan.Data.Meta.Offset(
                    Asr = 0,
                    Dhuhr = 0,
                    Fajr = 0,
                    Imsak = 0,
                    Isha = 0,
                    Maghrib = 0,
                    Midnight = 0,
                    Sunrise = 0,
                    Sunset = 0
                ),
                school = "",
                timezone = ""
            ), timings = Aladan.Data.Timings(
                Asr = "",
                Dhuhr = "",
                Fajr = "",
                Firstthird = "",
                Imsak = "",
                Isha = "",
                Lastthird = "",
                Maghrib = "",
                Midnight = "",
                Sunrise = "",
                Sunset = ""
            )
        ), status = ""
    )
    )

   init {
       viewModelScope.launch {
           val result = aladhanApi.getPrayerTimes("Amman" , "jordan")
           uiState.value = result
       }
   }
}