package com.yousof.athan.HomeScreenComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousof.athan.API.Aladan


@Composable
fun PrayerCard (

 data: Aladan,
title: String
)
{
    val time = when (title.lowercase()) {
        "fajr" -> data.data.timings.Fajr
        "dhuhr" -> data.data.timings.Dhuhr
        "asr" -> data.data.timings.Asr
        "maghrib" -> data.data.timings.Maghrib
        "isha" -> data.data.timings.Isha
        "sunrise" -> data.data.timings.Sunrise
        else -> "N/A"
    }
    Card (
        modifier = Modifier.width(80.dp)
            .height(80.dp)
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors( containerColor = Color(color = 0xFF200A59))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Text(text = time,
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}



