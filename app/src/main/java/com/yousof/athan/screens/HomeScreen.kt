package com.yousof.athan.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.yousof.athan.homeScreenComponents.currentDate
import com.yousof.athan.homeScreenComponents.currentPrayer
import com.yousof.athan.homeScreenComponents.prayerCard
import com.yousof.athan.viewModel.PrayerViewModel

@Composable
fun homeScreen(
    navController: NavHostController,
    viewModel: PrayerViewModel = viewModel(),
) {
    val uiState = viewModel.uiState.collectAsState()
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
            currentDate(uiState.value)
        }
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(36.dp),
        ) {
            prayerCard(title = "Fajr", data = uiState.value)
            prayerCard(title = "Dhuhr", data = uiState.value)
            prayerCard(title = "Sunrise", data = uiState.value)
        }
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(36.dp),
        ) {
            prayerCard(title = "Asr", data = uiState.value)
            prayerCard(title = "Maghrib", data = uiState.value)
            prayerCard(title = "Isha", data = uiState.value)
        }
        Spacer(modifier = Modifier.height(208.dp))
        Row { currentPrayer() }
        Row { currentPrayer() }
        Row { currentPrayer() }
    }
}
