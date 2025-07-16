package com.yousof.athan.Screens


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
import com.yousof.athan.HomeScreenComponents.CurrentDate
import com.yousof.athan.HomeScreenComponents.CurrentPrayer
import com.yousof.athan.HomeScreenComponents.PrayerCard
import com.yousof.athan.ViewModel.PrayerViewModel


@Composable

fun HomeScreen(
    navController: NavHostController,
    viewModel: PrayerViewModel = viewModel(),
){
    val uiState = viewModel.uiState.collectAsState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.padding(16.dp)
        ){
            CurrentDate(uiState.value)
        }
        Row (
            modifier = Modifier,
          horizontalArrangement = Arrangement.spacedBy(36.dp)
        ){
            PrayerCard(title = "Fajr", data = uiState.value)
            PrayerCard(title = "Dhuhr", data = uiState.value)
            PrayerCard(title = "Sunrise", data = uiState.value)
        }
        Row (
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(36.dp)
            ){
            PrayerCard(title = "Asr", data = uiState.value)
            PrayerCard(title = "Maghrib", data = uiState.value)
            PrayerCard(title = "Isha", data = uiState.value)
        }
        Spacer(modifier = Modifier.height(208.dp))
        Row (){ CurrentPrayer() }
        Row (){ CurrentPrayer() }
        Row (){ CurrentPrayer() }
    }
}
