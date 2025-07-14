package com.yousof.athan.ViewModel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector


sealed class NavigationScreen(
    val route: String,
    val title : String,
    val icon: ImageVector
)
{
    object Home: NavigationScreen("home", "Home", Icons.Default.Home)
    object Calender: NavigationScreen("calender", "Calender", Icons.Default.CalendarMonth)
    object KabaDirection: NavigationScreen("kabadirection", "KabaDirection", Icons.Default.CalendarMonth)
    object Settings: NavigationScreen("settings", "Settings", Icons.Default.CalendarMonth)
}