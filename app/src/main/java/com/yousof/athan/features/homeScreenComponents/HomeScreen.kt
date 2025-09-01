package com.yousof.athan.features.homeScreenComponents

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yousof.athan.features.viewModel.PrayerViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun homeScreen(
    navController: NavHostController,
    viewModel: PrayerViewModel,
    showNotification: (String, String) -> Unit,
) {
    val context = LocalContext.current

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.Athan != null) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                ) {
                    currentDate(uiState.Athan!!, uiState.city, uiState.country)
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                prayerCard(
                    title = "Fajr",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = {},
                )
                prayerCard(
                    title = "Sunrise",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = {},
                )
                prayerCard(
                    title = "Dhuhr",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = {},
                )
            }

            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                prayerCard(
                    title = "Asr",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = {},
                )
                prayerCard(
                    title = "Maghrib",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = {},
                )
                prayerCard(
                    title = "Isha",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = {},
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()),
            ) {
                val prayers =
                    listOf(
                        Triple("Fajr", uiState.uiStateTimeFajr, "Fajr"),
                        Triple("Sunrise", uiState.uiStateTimeSunrise, "Sunrise"),
                        Triple("Dhuhr", uiState.uiStateTimeDhuhr, "Dhuhr"),
                        Triple("Asr", uiState.uiStateTimeAsr, "Asr"),
                        Triple("Maghrib", uiState.uiStateTimeMaghrib, "Maghrib"),
                        Triple("Isha", uiState.uiStateTimeIsha, "Isha"),
                    )

                prayers.forEach { (name, time, label) ->
                    Row {
                        currentPrayer(
                            prayerName = name,
                            onToggleNotification = { isActive ->
                                showNotification(
                                    "Athan Erinnerung",
                                    "$label ${if (isActive) "Aktiviert" else "deaktiviert"}",
                                )
                            },
                            data = uiState.Athan!!,
                            timeToPray = time,
                        )
                    }
                }
            }
        }
    } else {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CircularProgressIndicator()
        }
    }
}
