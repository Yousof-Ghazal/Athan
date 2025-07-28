package com.yousof.athan.features.settingScreenComponents

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

@Composable
fun locationGPS(navHostController: NavHostController) {
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    val currentLocation = remember { mutableStateOf("") }
    var cityName by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("Ergebnis erscheint hier...") }
    val scopse = rememberCoroutineScope()
    var country by remember { mutableStateOf("") }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission(),
        ) { isGranted ->
            if (isGranted) {
                getCoordinates(context, fusedLocationClient) { lat, lon ->
                    resultText = "lat $lat \nlon $lon"
                }
            } else
                {
                    resultText = "standortberechtigung verweigert"
                }
        }
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {
                when (PackageManager.PERMISSION_GRANTED) {
                    ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) -> {
                        getCoordinates(context, fusedLocationClient) { lat, lon ->
                            resultText = "Lat: $lat\nLon: $lon"
                        }
                    }
                    else -> {
                        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                    }
                }
            },
        ) {
            Text(text = "Standort abrufen")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = resultText)
    }
}

fun getCoordinates(
    context: Context,
    fusedLocationClient: FusedLocationProviderClient,
    onResult: (Double, Double) -> Unit,
) {
    try {
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null)
                {
                    onResult(location.latitude, location.longitude)
                } else
                {
                    Toast.makeText(context, "Standort nicht verfügbar", Toast.LENGTH_SHORT).show()
                }
        }
    } catch (e: SecurityException) {
        Toast.makeText(context, "Berechtiung fehlt", Toast.LENGTH_SHORT).show()
    }
}
