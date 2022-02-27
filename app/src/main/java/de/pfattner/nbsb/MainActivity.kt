package de.pfattner.nbsb

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setShowWhenLocked(true)

        findViewById<View>(R.id.notification).setOnClickListener { showNotification() }
    }

    private fun showNotification() {
        val manager = NotificationManagerCompat.from(this)

        val channel = NotificationChannelCompat.Builder("nbsb", NotificationManager.IMPORTANCE_HIGH)
            .setName("Black Screen Bug Notifications")
            .build()

        manager.deleteNotificationChannel("nbsb")
        manager.createNotificationChannel(channel)

        val pendingIntent = PendingIntent.getActivity(this, 1, Intent.makeMainActivity(ComponentName(this, MainActivity::class.java)), PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this, channel.id)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setAutoCancel(true)
            .setContentTitle("Black Screen Bug")
            .setContentText("Hello World")
            .setSmallIcon(R.drawable.ic_android_black_24dp)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setContentIntent(pendingIntent)
            .build()

        manager.notify(1, notification)
    }
}