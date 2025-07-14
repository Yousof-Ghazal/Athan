package com.yousof.athan.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yousof.athan.HomeScreenComponents.CurrentDate
import com.yousof.athan.HomeScreenComponents.CurrentPrayer
import com.yousof.athan.HomeScreenComponents.PrayerCard
import com.yousof.athan.R
import com.yousof.athan.ViewModel.PrayerViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable

fun HomeScreen(
    navController: NavHostController,
    viewModel: PrayerViewModel = PrayerViewModel(),
){
    val uiState = viewModel.uiState.collectAsState()
    /*
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painterResource(id = R.drawable.fajr),
            contentDescription = "Fajir",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }

     */
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
        Row (
        ){
            CurrentPrayer()
        }
        Row (
        ){
            CurrentPrayer()
        }
        Row (
        ){
            CurrentPrayer()
        }
    }
}
