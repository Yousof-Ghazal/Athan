package com.yousof.athan.features.homeScreenComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.yousof.athan.features.viewModel.PrayerViewModel

@Composable
fun homeScreen(
    navController: NavHostController,
    viewModel: PrayerViewModel,
    showNotification: (String, String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.Athan!= null) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
            ) {
                currentDate(uiState.Athan!!)
            }
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                prayerCard(
                    title = "Fajr",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = { },
//                    title = "Fajr",
//                    data = uiState.value!!
                )
                prayerCard(
                    title = "Sunrise",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = { },
                    //    title = "Dhuhr", data = uiState.value!!
                )
                prayerCard(
                    title = "Dhuhr",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = { },
                    //    title = "Sunrise", data = uiState.value!!
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
                    onToggleNotification = { },
                    // title = "Asr", data = uiState.value!!
                )
                prayerCard(
                    title = "Maghrib",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = { },
                    // title = "Maghrib", data = uiState.value!!
                )
                prayerCard(
                    title = "Isha",
                    data = uiState.Athan!!,
                    isNotificationActive = true,
                    onToggleNotification = { },
                    // title = "Isha", data = uiState.value!!
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Column (
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ){
                Row {
                    currentPrayer(
                        prayerName = "Fajr",
                        onToggleNotification = {
                                isActive ->
                            showNotification(
                                "Athan Erinnerung",
                                "Fajr ${if (isActive) "Aktiviert" else "deaktiviert"}")},
                        data = uiState.Athan!!,
                        timeToPray = uiState.uiStateTimeFajr
                    )
                }
                Row {
                    currentPrayer(
                        prayerName = "Sunrise",
                        onToggleNotification = {
                                isActive ->
                            showNotification("Athan Erinnerung",
                                "Sunrise ${if (isActive) "Aktiviert" else "deaktiviert"}")},
                        data = uiState.Athan!!,
                        timeToPray = uiState.uiStateTimeSunrise
                    )
                }

                Row {
                    currentPrayer(
                        prayerName = "Dhuhr",
                        onToggleNotification = {
                                isActive ->
                            showNotification("Athan Erinnerung",
                                "Dhuhr ${if (isActive) "Aktiviert" else "deaktiviert"}")},
                        data = uiState.Athan!!,
                        timeToPray = uiState.uiStateTimeDhuhr
                    )
                }
                Row {
                    currentPrayer(
                        prayerName = "Asr",
                        onToggleNotification = {
                                isActive ->
                            showNotification("Athan Erinnerung",
                                "Asr ${if (isActive) "Aktiviert" else "deaktiviert"}")},
                        data = uiState.Athan!!,
                        timeToPray = uiState.uiStateTimeAsr
                    )
                }
                Row {
                    currentPrayer(
                        prayerName = "Maghrib",
                        onToggleNotification = {
                                isActive ->
                            showNotification("Athan Erinnerung",
                                "Maghrib ${if (isActive) "Aktiviert" else "deaktiviert"}")},
                        data = uiState.Athan!!,
                        timeToPray = uiState.uiStateTimeMaghrib
                    )
                }

                Row {
                    currentPrayer(
                        prayerName = "Isha",
                        onToggleNotification = {
                                isActive ->
                            showNotification("Athan Erinnerung",
                                "Isha ${if (isActive) "Aktiviert" else "deaktiviert"}")},
                        data = uiState.Athan!!,
                        timeToPray = uiState.uiStateTimeIsha
                    )
                }
            }
        }
    }
    else { (Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
        ) {
                CircularProgressIndicator()
            }
        )
    }
}
