package com.yousof.athan.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yousof.athan.HomeScreenComponents.CurrentDate
import com.yousof.athan.R
import com.yousof.athan.ViewModel.PrayerViewModel

@Composable

fun HomeScreen(
viewModel: PrayerViewModel = PrayerViewModel()
){
    val uiState = viewModel.uiState.collectAsState()
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
    Row(
        modifier = Modifier.fillMaxSize().padding(30.dp)
    ){
       CurrentDate(uiState.value)
    }

}