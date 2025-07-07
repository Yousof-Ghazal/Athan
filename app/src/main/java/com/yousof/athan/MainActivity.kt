package com.yousof.athan

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.yousof.athan.API.RetrofitObject
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TEST", "onCreate called")

        super.onCreate(savedInstanceState)
     //   enableEdgeToEdge()
        lifecycleScope.launch {
            try {
                val response = RetrofitObject.api.getPrayerTimes(
                    city = "Herford",
                    country = "Germany",
                    method = 2
                )
                val timings = response.data.timings
                Log.d("PrayerTimes", "Fajr: ${timings.Fajr}")
                Log.d("PrayerTimes", "Sunrise:${timings.Sunrise}")
                Log.d("PrayerTimes", "Dhuhr: ${timings.Dhuhr}")
                Log.d("PrayerTimes", "Asr: ${timings.Asr}")
                Log.d("PrayerTimes", "Maghrib: ${timings.Maghrib}")
                Log.d("PrayerTimes", "Isha: ${timings.Isha}")
            } catch (e: Exception) {
                Log.e("API_ERROR", "Fehler: ${e.message}")
            }
        }
        setContent {


        }
    }
}
