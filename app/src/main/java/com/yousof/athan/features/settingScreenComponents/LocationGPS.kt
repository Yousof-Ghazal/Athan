package com.yousof.athan.features.settingScreenComponents

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale


var city   = ""
var country = ""

@Composable
fun locationGPS(navHostController: NavHostController) {
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    var resultText by remember { mutableStateOf("Result appears here...") }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission(),
        ) { isGranted ->
            if (isGranted) {
                getCoordinates(context, fusedLocationClient) { city2, country2 ->
                    resultText = "City $city \nCountry $country"
                }
            } else {
                resultText = "location permission denied"
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
                        getCoordinates(context, fusedLocationClient) { city, country ->
                            resultText = "City $city \nCountry $country"
                        }
                    }
                    else -> {
                        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                    }
                }
            },
        ) {
            Text(text = "Location detection")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = resultText)
    }
}

@SuppressLint("SuspiciousIndentation")
fun getCoordinates(
    context: Context,
    fusedLocationClient: FusedLocationProviderClient,
    onResult: (String, String) -> Unit,
) {
    try {
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                val (city1, country1) = getCityAndCountryFromLocation(context, location.latitude, location.longitude)
                onResult(city, country)
            } else {
                Toast.makeText(context, "Location not available", Toast.LENGTH_SHORT).show()
            }
        }
    } catch (e: SecurityException) {
        Toast.makeText(context, "Authorization missing", Toast.LENGTH_SHORT).show()
    }
}

fun getCityAndCountryFromLocation(
    context: Context,
    latitude: Double,
    longitude: Double,
): Pair<String, String> {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addressList = geocoder.getFromLocation(latitude, longitude, 1)

    return if (!addressList.isNullOrEmpty()) {
        val address = addressList[0]
        city = address.locality ?: address.subAdminArea ?: "unknown"
        country = address.countryName ?: "unknown"
        Pair(city, country)
    } else {
        Pair("unknown ", "unknown ")
    }
}
