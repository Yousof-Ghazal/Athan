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
    private val aladhanApi = RetrofitObject.aladanApi
    var uiState = MutableStateFlow(PrayViewModelState())

    init {
        viewModelScope.launch {
            val result = aladhanApi.getPrayerTimes("Herford", "Germany")
            while (true) {
                val timeTofajr = countdownToPrayer(result.data.timings.Fajr)
                val timeToSunrise = countdownToPrayer(result.data.timings.Sunrise)
                val timeToDhuhr = countdownToPrayer(result.data.timings.Dhuhr)
                val timeToAsr = countdownToPrayer(result.data.timings.Asr)
                val timeToMaghrib = countdownToPrayer(result.data.timings.Maghrib)
                val timeToIsha = countdownToPrayer(result.data.timings.Isha)
                uiState.value =
                    PrayViewModelState(
                        result, timeTofajr,
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

class CountDownToPrayer(val minutes: Long = 0L, val hours: Long = 0L, val seconds: Long = 0L)

fun countdownToPrayer(salahTime: String): CountDownToPrayer { // class

    val prayerTime =
        try {
            LocalTime.parse(salahTime.split(" ")[0])
        } catch (e: Exception) {
            LocalTime.MIDNIGHT
        }
    var remainingSeconds: Long = 0
    val now = LocalTime.now()
    val duration = Duration.between(now, prayerTime)
    remainingSeconds = duration.seconds
    val hours = remainingSeconds / 3600
    val minutes = (remainingSeconds % 3600) / 60
    val seconds = remainingSeconds % 60

    val countDownToPrayerObj = CountDownToPrayer(minutes, hours, seconds)

    return countDownToPrayerObj
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
