package com.yousof.athan.settingScreenComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun date() {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        colors = CardDefaults.cardColors(Color(0x99482864)),
        border = BorderStroke(1.dp, Color.White),
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start,
            ) {
                Box(
                    modifier =
                        Modifier.size(40.dp)
                            .clip(shape = CircleShape)
                            .background(Color(0x99482864)),
                ) {
                    Icon(
                        imageVector = Icons.Filled.CalendarMonth,
                        contentDescription = "Date",
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.clickable { }.weight(1f).padding(end = 16.dp),
            ) {
                Text(
                    text = "dd/mm/yyyy",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
            }
        }
    }
}
