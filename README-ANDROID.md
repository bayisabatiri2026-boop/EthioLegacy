# EthioLegacy Android APK fix

This package keeps the supplied EthioLegacy HTML app and adds the native Android permission declarations/permission prompt handler plus the EthioLegacy logo.

## What changed
- Android manifest declares CAMERA, RECORD_AUDIO, MODIFY_AUDIO_SETTINGS and POST_NOTIFICATIONS.
- NativePermissions Capacitor plugin requests Android runtime permissions and returns their status.
- Settings > Permissions calls the native plugin in the installed APK.
- Service-worker registration is skipped inside the native Capacitor app to avoid interfering with the Capacitor bridge.
- `logo.png` replaces the text/placeholder brand mark in the login, header and settings screens, and custom Android launcher icons replace the default Capacitor icon.
- GitHub Actions workflow builds a debug APK artifact.

## GitHub steps
1. Upload/replace the repository files with the contents of this folder (keep `.github/workflows/android-apk.yml`).
2. In the repository, open **Actions**.
3. Select **Build EthioLegacy APK** and tap **Run workflow** (or push to `main`).
4. Wait for the green check mark. Open the completed workflow run and download **EthioLegacy-debug-apk** under Artifacts.
5. Install the APK on Android. Open EthioLegacy > Settings > Permissions and grant Camera, Microphone and Notifications.

## Important
- Android permission prompts can only be requested by the installed native APK; GitHub Pages in Chrome uses browser permissions instead.
- Android 13+ displays the notification permission prompt. On older Android versions notification permission is controlled differently.
- This permission fix does not itself implement remote push delivery while the app is closed. That requires Firebase Cloud Messaging (FCM) and a server/Cloud Function to send pushes.
- The supplied HTML references Firebase services. Keep the existing Firebase project and configure Firebase Authentication, Firestore and Storage rules appropriately.
- This is a debug APK. For Play Store release, create a signed release/AAB and configure a permanent signing key.
