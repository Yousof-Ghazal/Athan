package com.yousof.athan.Screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.yousof.athan.HomeScreenComponents.PrayerCard
import com.yousof.athan.ViewModel.PrayerViewModel
import java.time.LocalDateTime
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun CalenderScreen(
    navController: NavHostController,
    viewModel: PrayerViewModel = viewModel(),
) {
    fun LocalDateTime.toMillis(): Long =
        this.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    val dateTime = LocalDateTime.now()
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = dateTime.toMillis())
    val uiState = viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 24.dp)
        ){
            Row (
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(36.dp)
            ){
                PrayerCard(title = "Fajr", data = uiState.value)
                PrayerCard(title = "Dhuhr", data = uiState.value)
                PrayerCard(title = "Sunrise", data = uiState.value)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row (
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(36.dp)
            ){
                PrayerCard(title = "Asr", data = uiState.value)
                PrayerCard(title = "Maghrib", data = uiState.value)
                PrayerCard(title = "Isha", data = uiState.value)
            }
        }
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            DatePicker(
                state = datePickerState,
                modifier = Modifier,
                colors = DatePickerDefaults.colors(
                    selectedDayContainerColor = Color(0x99482864),
                    selectedDayContentColor = Color.White,
                    todayContentColor = Color(0x99482864),
                    dayContentColor = Color.Black,
                    weekdayContentColor = Color.DarkGray
                )
            )
        }
    }
}
