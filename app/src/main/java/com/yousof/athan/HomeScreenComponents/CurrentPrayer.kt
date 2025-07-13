package com.yousof.athan.HomeScreenComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousof.athan.API.Aladan

@Composable

fun CurrentPrayer (
) {

    var timeLeft by remember { mutableStateOf(0L) }
    var nextPrayer by remember { mutableStateOf("...") }

    Card (
        modifier = Modifier
            .width(380.dp)
            .height(80.dp)
            .padding(4.dp),
        colors = CardDefaults.cardColors(Color.Transparent),
        border = BorderStroke(1.dp, Color.White),
        ){
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
           verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Dhuhr",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "Left: 03.01.02",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
            Icon(
                Icons.Filled.NotificationsActive, contentDescription = "Notficication",
                modifier = Modifier
                    .padding(8.dp)
                    .width(37.dp)
                    .height(35.dp)
                , tint = Color.White
            )
        }
    }


}





@Composable
@Preview( showBackground = true)

fun CurrentpreayerPRev (){
    CurrentPrayer()
}