package com.yousof.athan.features.homeScreenComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousof.athan.api.Aladan
import com.yousof.athan.features.viewModel.CountDownToPrayer
import kotlin.math.absoluteValue

@Composable
fun currentPrayer(
    data: Aladan,
    prayerName: String,
    onToggleNotification: (Boolean) -> Unit,
    timeToPray: CountDownToPrayer,
) {
    var isActive by remember { mutableStateOf(false) }
    Card(
        modifier =
            Modifier
                .width(380.dp)
                .height(80.dp)
                .padding(4.dp),
        colors = CardDefaults.cardColors(Color.Transparent),
        border = BorderStroke(1.dp, Color.White),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = prayerName,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
            )
            countdownToPrayerView(timeToPray)

            Icon(
                imageVector =
                    if (isActive) {
                        Icons.Filled.NotificationsActive
                    } else {
                        Icons.Filled.Notifications
                    },
                contentDescription = "notification",
                modifier =
                    Modifier
                        .padding(8.dp)
                        .width(37.dp)
                        .height(35.dp)
                        .clickable {
                            isActive = !isActive
                            onToggleNotification(isActive)
                        },
                tint = Color.White,
            )
        }
    }
}

@Composable
fun countdownToPrayerView(time: CountDownToPrayer) {
    val isPassed = time.hours <= 0 && time.minutes <= 0 && time.seconds <= 0
    val lable = if (isPassed) " - " else "left"

    Text(
        text =
            String.format(
                "$lable %02d:%02d:%02d",
                time.hours.absoluteValue,
                time.minutes.absoluteValue,
                time.seconds.absoluteValue,
            ),
        color = Color.White,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
    )
}
