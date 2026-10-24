ETHIOLEGACY ANDROID WRAPPER PROJECT (not a compiled APK yet)

1. Deploy the updated EthioLegacy website to Netlify using HTTPS.
2. Edit app/src/main/java/com/ethiolegacy/app/MainActivity.java and replace WEBSITE_URL with your real Netlify URL.
3. Open this folder in Android Studio (recent version) with Android SDK Platform 35 installed.
4. Let Gradle sync, then choose Build > Build Bundle(s) / APK(s) > Build APK(s).
5. Android Studio will show the APK location after successful build.

This wrapper loads the hosted website, so Firebase configuration and website hosting must already work. It requests camera/microphone access for web calls and supports the website file picker. Background push notifications are not implemented in this wrapper; configure Firebase Cloud Messaging separately. Test calling and uploads on a real device before sharing the APK.
