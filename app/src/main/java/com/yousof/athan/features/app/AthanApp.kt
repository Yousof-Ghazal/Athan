package com.yousof.athan.features.app

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yousof.athan.R
import com.yousof.athan.features.calender.calenderScreen
import com.yousof.athan.features.homeScreenComponents.homeScreen
import com.yousof.athan.features.settingScreenComponents.locationGPS
import com.yousof.athan.features.settingScreenComponents.settingsScreen
import com.yousof.athan.features.viewModel.NavigationScreen
import com.yousof.athan.features.viewModel.PrayerViewModel

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun athanApp(
    showNotification: (String, String) -> Unit,
    navController: NavHostController = rememberNavController(),
    viewModel: PrayerViewModel,
) {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painterResource(id = R.drawable.fajr),
            contentDescription = "Fajir",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        NavHost(
            navController = navController,
            startDestination = NavigationScreen.Home.route,
            modifier = Modifier.padding(bottom = 80.dp),
        ) {
            composable(NavigationScreen.Home.route) {
                homeScreen(
                    navController,
                    showNotification = showNotification,
                    viewModel = PrayerViewModel(),
                )
                // Das bedeutet: Der Home-Screen bekommt jetzt die Kontrolle über die Benachrichtigungen.
            }
            composable(NavigationScreen.Calender.route) { calenderScreen(navController) }
            composable(NavigationScreen.KabaDirection.route) { kabaDirection(navController) }
            composable(NavigationScreen.Settings.route) { settingsScreen(navController) }
            composable(NavigationScreen.LocationGPS.route) { locationGPS(navController) }
        }
        bottombar(
            navController = navController,
            selectedIndex = selectedIndex,
            onItemSelected = { index -> selectedIndex = index },
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}
