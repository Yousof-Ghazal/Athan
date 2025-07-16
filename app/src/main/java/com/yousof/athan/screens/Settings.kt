package com.yousof.athan.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.yousof.athan.settingScreenComponents.AboutUs
import com.yousof.athan.settingScreenComponents.Date
import com.yousof.athan.settingScreenComponents.HourFormat
import com.yousof.athan.settingScreenComponents.Language
import com.yousof.athan.settingScreenComponents.Location

@Composable
fun settingsScreen(navController: NavHostController) {
    Column {
        HeaderText()
        HourFormat()
        Language()
        Location()
        Date()
        AboutUs()
    }
}

@Composable fun headerText() {
    Text(
        text = "Settings",
        fontFamily = FontFamily.Default,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, bottom = 40.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
    )
}
