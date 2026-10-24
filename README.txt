ETHIOLEGACY — UPDATED WEBSITE SOURCE

Included updates:
- Chat text input plus separate photo and file/media upload buttons.
- Invite action now shares/copies the current live website URL with invitation text.
- Search field on Calls filters members by display name/email.
- Settings > Change password supports show/hide and uses Firebase re-authentication before updating the password.
- Screen/browser notifications work only after permission is granted and while the page is running/connected to Firebase.

IMPORTANT SETUP
1. Replace all PASTE_YOUR_NEW_* values in index.html with your Firebase Web App config.
2. Enable Firebase Authentication (Email/Password), Firestore and Storage.
3. Set secure Firestore and Storage rules; do not use public write access.
4. Host over HTTPS (Netlify is fine). Test signup, chat, uploads and calls with two real accounts/devices.
5. For reliable background notifications when the app is closed, configure Firebase Cloud Messaging (FCM), a VAPID key, service worker and a server/Cloud Function that sends push notifications. This source update does not by itself enable background push.
6. WebRTC calling currently has STUN only; some mobile networks need a TURN server for reliable calling. Calls must be tested on two devices/networks.

PASSWORD CHANGE
The password change feature requires an Email/Password Firebase account and the current password. Accounts using other sign-in methods need provider-specific credential management.

APK
The Android Studio wrapper project is provided separately in EthioLegacy-Android-Project.zip. It opens the hosted HTTPS website in a WebView. Set your deployed website URL in MainActivity.java before building. This is a source project, not a compiled APK. An Android SDK/Gradle build environment is required to compile the APK.

SPEED
The app uses Firebase live listeners and cloud storage; actual speed depends on internet quality, Firebase region/rules, file sizes and device performance. No source code can guarantee highest speed on every connection.
