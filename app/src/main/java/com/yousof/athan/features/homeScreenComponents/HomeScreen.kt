package com.yousof.athan.features.homeScreenComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.yousof.athan.features.viewModel.PrayerViewModel

@Composable
fun homeScreen(
    navController: NavHostController,
    viewModel: PrayerViewModel = viewModel(),
    showNotification: (String, String) -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState()

    if (uiState.value != null) {
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
                currentDate(uiState.value!!)
            }
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(36.dp),
            ) {
                prayerCard(title = "Fajr", data = uiState.value!!)
                prayerCard(title = "Dhuhr", data = uiState.value!!)
                prayerCard(title = "Sunrise", data = uiState.value!!)
            }
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(36.dp),
            ) {
                prayerCard(title = "Asr", data = uiState.value!!)
                prayerCard(title = "Maghrib", data = uiState.value!!)
                prayerCard(title = "Isha", data = uiState.value!!)
            }
            Spacer(modifier = Modifier.height(208.dp))
            Row {
                currentPrayer(
                    prayerName = "dhuhr",
                    onToggleNotification = {
                            isActive ->
                        showNotification(
                            "Athan Erinnerung",
                            "Dhuhr ${if (isActive) "Aktiviert" else "deaktiviert"}",
                        )
                    },
                    data = uiState.value!!,
                )
            }
            Row {
                currentPrayer(
                    prayerName = "Asr",
                    onToggleNotification = {
                            isActive ->
                        showNotification("Athan Erinnerung", "Asr ${if (isActive) "Aktiviert" else "deaktiviert"}")
                    },
                    data = uiState.value!!,
                )
            }
            Row {
                currentPrayer(
                    prayerName = "Maghrib",
                    onToggleNotification = {
                            isActive ->
                        showNotification("Athan Erinnerung", "Maghrib ${if (isActive) "Aktiviert" else "deaktiviert"}")
                    },
                    data = uiState.value!!,
                )
            }
        }
    } else {
        (
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CircularProgressIndicator()
            }
        )
    }
}
