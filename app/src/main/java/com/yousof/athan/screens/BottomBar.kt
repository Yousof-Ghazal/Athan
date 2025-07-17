package com.yousof.athan.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.SettingsApplications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun bottombar(
    modifier: Modifier = Modifier.height(66.dp).fillMaxWidth(),
    navController: NavHostController = rememberNavController(),
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
) {
    val routes = listOf("Home", "Calender", "KabaDirection", "Settings")
    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.CalendarMonth,
        Icons.Filled.Directions,
        Icons.Filled.SettingsApplications)

    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(color = 0xFF294782), shape = RoundedCornerShape(24.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        routes.forEachIndexed { index, route -> // man sagt programm du gehst die liste routes durch
            // für jede Route erstellst du eine column
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier =
                    Modifier
                        .padding(vertical = 8.dp)
                        .clickable {
                            onItemSelected(index)
                            navController.navigate(route)
                        },
            ) {
                Icon(
                    imageVector = icons[index],
                    contentDescription = route,
                    modifier =
                        Modifier
                            .width(50.dp)
                            .height(50.dp),
                    tint = if (selectedIndex == index) Color(color = 0xFF3F6EA8) else Color.White,
                )
            }
        }
    }
}
