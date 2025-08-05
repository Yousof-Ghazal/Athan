package com.yousof.athan.features.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yousof.athan.api.Aladan
import com.yousof.athan.api.RetrofitObject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalTime

class PrayerViewModel : ViewModel() {
    private var result: Aladan? = null
    private val aladhanApi = RetrofitObject.aladanApi
    var uiState = MutableStateFlow(PrayViewModelState())
    private var city = "Amman"
    private var country = "Jordan"

    fun setCityAndCountry(
        city: String,
        country: String,
    ) {
        this.city = city
        this.country = country
        viewModelScope.launch {
            fitchPrayTime()
        }
    }

    suspend fun fitchPrayTime() {
        var result =
            aladhanApi.getPrayerTimes(
                if (city.isNullOrBlank()) "Mecca" else city,
                if (country.isNullOrBlank()) "Saudi Arabia" else country,
            )

        this.result = result
    }

    init {
        viewModelScope.launch {
            fitchPrayTime()
            while (true) {
                val timeTofajr = countdownToPrayer(result!!.data.timings.Fajr)
                val timeToSunrise = countdownToPrayer(result!!.data.timings.Sunrise)
                val timeToDhuhr = countdownToPrayer(result!!.data.timings.Dhuhr)
                val timeToAsr = countdownToPrayer(result!!.data.timings.Asr)
                val timeToMaghrib = countdownToPrayer(result!!.data.timings.Maghrib)
                val timeToIsha = countdownToPrayer(result!!.data.timings.Isha)

                uiState.value =
                    PrayViewModelState(
                        result,
                        timeTofajr,
                        timeToSunrise,
                        timeToDhuhr,
                        timeToAsr,
                        timeToMaghrib,
                        timeToIsha,
                    )

                delay(1000)
            }
        }
    }
}

class CountDownToPrayer(
    val minutes: Long = 0L,
    val hours: Long = 0L,
    val seconds: Long = 0L,
)

fun countdownToPrayer(salahTime: String): CountDownToPrayer {
    val prayerTime =
        try {
            LocalTime.parse(salahTime.split(" ")[0])
        } catch (e: Exception) {
            LocalTime.MIDNIGHT
        }

    val now = LocalTime.now()
    val remainingSeconds = Duration.between(now, prayerTime).seconds
    val hours = remainingSeconds / 3600
    val minutes = (remainingSeconds % 3600) / 60
    val seconds = remainingSeconds % 60

    return CountDownToPrayer(minutes, hours, seconds)
}

data class PrayViewModelState(
    var Athan: Aladan? = null,
    var uiStateTimeFajr: CountDownToPrayer = CountDownToPrayer(),
    var uiStateTimeSunrise: CountDownToPrayer = CountDownToPrayer(),
    var uiStateTimeDhuhr: CountDownToPrayer = CountDownToPrayer(),
    var uiStateTimeAsr: CountDownToPrayer = CountDownToPrayer(),
    var uiStateTimeMaghrib: CountDownToPrayer = CountDownToPrayer(),
    var uiStateTimeIsha: CountDownToPrayer = CountDownToPrayer(),
)
