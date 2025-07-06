# Athan


Create & Organize Jira Board for Prayer Times App Project
Set up a dedicated Jira board for this project. Organize tasks by priority and categories: Core Use Cases, Firebase Integration, and Technical Requirements. Provide clear descriptions and assign priorities to enable smooth sprint planning.

Priority 1 — Core Use Cases (Essential Features)
- Display Prayer Times
- Show accurate daily prayer times (Fajr to Isha) based on GPS location or manual location selection.
- Ensure prayer times update automatically according to the user’s current location or selected city.
- Play Adhan Sound & Notifications
- Automatically play the Adhan at prayer times with customizable sound options.
- Provide optional vibration alerts for user preference.
- Sync Prayer Times at Midnight Using WorkManager
- Schedule a background sync at midnight to update prayer times via API, only when the device is connected to Wi-Fi and charging.
- Offline Access
- Cache prayer times locally for offline usage after the initial sync.
- Location Settings
- Enable both manual location input and automatic location fetching via GPS.


Priority 2 — User Experience Enhancements
- Dark Theme Support
- Provide a dark mode for comfortable viewing in low-light environments.
- Compose Glance (Quick Widget)
- Create a Jetpack Compose widget showing the next prayer time with a countdown and quick access to the app.
- Multilingual Support
- Support multiple languages including Arabic, English, Urdu, and French.
- Random Background Image
- Display a random background image on each app launch using the Unsplash API or similar service.
- Select Date from Calendar for Prayer Times
- Allow users to select any date via a calendar UI and display prayer times for that date.
- Support fetching or calculating prayer times for arbitrary dates, with offline caching.
- Tablet Support
- Optimize the UI for tablets to ensure a clean, responsive experience.
- Add “Share App” Button
- Implement a feature allowing users to easily share the app link using Android’s native share intent.


Priority 3 — Firebase Integration
- Firebase Crashlytics
- Integrate Crashlytics for real-time crash reporting.
- Support manual logging for non-fatal exceptions and custom events.
- Firebase Analytics
- Integrate Analytics to track user engagement.
- Log custom events such as prayer time views, widget interactions, and notification opens.
- Firebase Cloud Messaging (FCM)
- Set up push notifications for prayer time reminders, app updates, and special messages (e.g., Ramadan, Eid).
- Support message handling in both background and foreground modes.


Priority 4 — Technical Requirements & Repository Setup
- Local Data Persistence Using Room
- Store prayer times, user settings, and cached images locally using Room database.
- Manual Dependency Injection
- Avoid DI libraries (Koin, Dagger). Use manual DI approaches such as constructor injection or service locators.
- Modular Project Structure
- Organize the project code modularly for easier maintenance and future enhancements.
- GitHub Repository Initialization
- Initialize and push the project to GitHub.
- Include a proper .gitignore for Android projects.
- Maintain clear, descriptive commit messages reflecting task progress.
- Share the repository link upon setup completion.
  
- Required Screens:
  
- Splash Screen
Display app logo and initiate data loading.
- Home Screen
Show today’s prayer times, next prayer countdown, and quick access to settings.
- Prayer Times Detail Screen
Display prayer times for a selected date with detailed timings.
- Settings Screen
- Location settings (manual and GPS), notification preferences, sound/vibration customization, language selection, theme toggle (light/dark).
- Widget Setup Screen
Configure Jetpack Compose glance widget options.
- About/Share Screen
Include app info and "Share App" button.
- Error/Offline Screen
Show appropriate messages when offline or API sync fails.
Requirements to Publish App on APKPure
Upload APK and complete app details on APKPure.
Add app icon
Add ktlint Formatter
Integrate ktlint Gradle plugin into the project.
Story Template
User Story: Display Prayer Times
Title: As a user, I want to see accurate daily prayer times so that I can perform my prayers on time. 
