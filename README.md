Notification Black Screen Bug (NBSB)
====================================

This app shows how to reproduce the black screen bug on incoming notifications.

To reproduce this issue perform the following steps:

1. Install and launch this app. Dragging down the notification drawer and showing a notification works as expected.
   Screenshots: [Notifications ok](docs/notification_ok.png), [Notification drawer ok](docs/notification_drawer_ok.png)

2. Keep the app in foreground, lock the display and unlock it. Try to show the notification again. Now the rest of the screen is black. Dragging down the notification drawer also shows a black background.
   Screenshots: [Notifications error](docs/notification_error.png), [Notification drawer error](docs/notification_drawer_error.png)

3. Put the app into background, lock and unlock the display. Now everything is ok.

Notice: In this case this issue only occurs when the activity has called `setShowWhenLocked(true)`, see [MainActivity.onCreate](app/src/main/java/de/pfattner/nbsb/MainActivity.kt).  
