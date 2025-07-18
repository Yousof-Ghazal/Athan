package com.yousof.athan

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
import com.yousof.athan.screens.bottombar
import com.yousof.athan.screens.calenderScreen
import com.yousof.athan.screens.homeScreen
import com.yousof.athan.screens.kabaDirection
import com.yousof.athan.screens.settingsScreen
import com.yousof.athan.viewModel.NavigationScreen

@Composable
fun athanApp(navController: NavHostController = rememberNavController()) {
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
            composable(NavigationScreen.Home.route) { homeScreen(navController) }
            composable(NavigationScreen.Calender.route) { calenderScreen(navController) }
            composable(NavigationScreen.KabaDirection.route) { kabaDirection(navController) }
            composable(NavigationScreen.Settings.route) { settingsScreen(navController) }
        }
        bottombar(
            navController = navController,
            selectedIndex = selectedIndex,
            onItemSelected = { index -> selectedIndex = index },
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}
