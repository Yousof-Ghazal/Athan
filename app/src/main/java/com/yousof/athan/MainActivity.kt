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
import com.yousof.athan.features.app.athanApp

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 100)
        }
        createNotificationChannel()
        setContent {
            athanApp(showNotification = { title, msg -> showImmediateNotification(title, msg) })
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(
                    "AthanReminder",
                    "Athan Reminder",
                    NotificationManager.IMPORTANCE_DEFAULT,
                ).apply {
                    description = "Kanal für gebetszeiten erinnerung"
                }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
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

        with(NotificationManagerCompat.from(this)) {
            notify(System.currentTimeMillis().toInt(), builder.build())
        }
    }
}
