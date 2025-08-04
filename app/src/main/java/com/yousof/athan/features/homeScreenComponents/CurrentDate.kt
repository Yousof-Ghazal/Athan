package com.yousof.athan.features.homeScreenComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousof.athan.api.Aladan

// Date optimized
@Composable
fun currentDate(data: Aladan) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
    ) {

   //testing
        Text (
            text = "howww", fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White, )


        Row(
            modifier = Modifier.fillMaxWidth().padding(end = 147.dp, top = 35.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                text = data.data.date.readable,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
            )

        }


        Row(
            modifier = Modifier.fillMaxWidth().padding(end = 147.dp, top = 8.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                text =
                    data.data.date.hijri.month.en +
                        " / " + data.data.date.hijri.month.number +
                        " / " + data.data.date.hijri.year,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
            )
        }
    }
}
