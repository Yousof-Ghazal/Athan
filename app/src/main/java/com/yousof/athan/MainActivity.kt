package com.yousof.athan

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yousof.athan.features.app.athanApp
import com.yousof.athan.features.viewModel.PrayerViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 100)
            // man fragt nach erlaubnis ob man benachrichtigung schicken darf
        }
        createNotificationChannel() // man erstellt ein benachrichtigungskanal,
        // damit die app überhaupt benachrichtigung schicken kann
        setContent {
            val viewModel: PrayerViewModel = viewModel()
            athanApp(
                showNotification = { title, msg -> showImmediateNotification(title, msg) },
                viewModel = viewModel,
            ) // Coroutine zum Empfangen der Events
        }
    }

    // Ab Android 8 (Oreo) muss jede App, die Benachrichtigungen senden will,
    // einen Notification Channel definieren.
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(
                    "AthanReminder",
                    "Athan Reminder",
                    NotificationManager.IMPORTANCE_DEFAULT,
                ).apply {
                    // apply wird benutzt, um die description zu setzen
                    description = "Kanal für gebetszeiten erinnerung"
                }
            // man sendet zu diesem kanal die benachrichtigung
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
            // (MANAGER)Du bekommst Zugriff auf den Systemdienst für
            // Benachrichtigungen und registrierst den Kanal.
        }
    }

    @SuppressLint("MissingPermission")
    fun showImmediateNotification(
        title: String,
        message: String,
    ) {
        val builder =
            NotificationCompat.Builder(this, "AthanReminder")
                .setSmallIcon(R.drawable.mosque)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Du schickst die Benachrichtigung ans System.
        with(NotificationManagerCompat.from(this)) {
            notify(System.currentTimeMillis().toInt(), builder.build())
        }
    }
}
