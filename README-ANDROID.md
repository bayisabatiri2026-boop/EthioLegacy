# EthioLegacy Android permission and app-settings repair

## Included corrections
- Keeps the supplied EthioLegacy web app and Firebase configuration.
- Aligns Capacitor application ID and Java package at `com.ethiolegacy.app`.
- Adds Android manifest declarations for internet, network, camera, microphone, audio settings and Android 13+ notifications.
- Registers a Capacitor `NativePermissions` plugin.
- Settings > Permissions requests native Android runtime permissions and performs a camera/microphone test.
- Adds Settings > Android app settings, which opens Android's App info/settings page for EthioLegacy. From there users can manage permissions and notifications.
- Keeps the EthioLegacy launcher icon resources from the earlier package.
- Uses Capacitor 7.4.3 consistently and Java 21 in GitHub Actions.

## Install into GitHub
Upload the CONTENTS of this folder into the root of the EthioLegacy repository, replacing matching files. Keep the `.github` folder and hidden workflow file.

Then open GitHub > Actions > Build EthioLegacy Android APK > Run workflow.
Download `EthioLegacy-debug-apk` after the run succeeds.

## Test on Android
1. Uninstall the previous test APK if Android refuses to update because its signing key differs.
2. Install the new APK.
3. Open EthioLegacy > Settings > Permissions and grant Camera, Microphone and Notifications when Android asks.
4. Open EthioLegacy > Settings > Android app settings to reach Android's native App info page.

## Important limits
- This repairs native permission prompting and provides a shortcut to Android app settings. It does not create Chrome's exact PWA "Site settings" menu; native APKs use Android App info settings instead.
- Android 13+ asks for notification permission at runtime. Earlier Android versions manage notification permission differently.
- This does not implement remote push notifications by itself. Firebase Cloud Messaging (FCM), Android Firebase configuration (`google-services.json`), and a sender/server or Cloud Function are required for reliable background push delivery.
- Camera/microphone prompts still depend on the Android WebView and device OS. Test on a physical phone after installing the new APK.
- Existing Firebase authentication, Firestore, Storage, and WebRTC features are retained but cannot be verified from a static ZIP; they require live Firebase configuration and two-device testing.
