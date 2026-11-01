# EthioLegacy — Modernized Android Wrapper (Existing App Preserved)

## What this package does
This package keeps the existing EthioLegacy web application as its source and prepares it to be packaged as a native Android app using Capacitor.

**The original `index.html` has been copied unchanged** from the latest available project file (`index(20261030-164956).html`). Existing Firebase code, invitation flow, chat/call/community logic, languages, and app identity inside that file have not been rewritten here.

## Included
- `www/index.html` — existing EthioLegacy source, unchanged
- `www/manifest.webmanifest` — install metadata
- `www/icons/` — Android/PWA launcher icon assets
- `capacitor.config.ts` — Android app ID and display name
- `package.json` — Capacitor setup

## Build the Android project
You need a computer with Node.js LTS, Android Studio, and the Android SDK.

1. Extract this folder.
2. Open a terminal inside this folder.
3. Run:
   ```bash
   npm install
   npx cap add android
   npx cap sync android
   npx cap open android
   ```
4. Android Studio opens the native project. Test on a real phone first.
5. For a Play Store release, use Android Studio **Build > Generate Signed Bundle / APK** and generate a signed **Android App Bundle (.aab)**.

Application ID: `com.ethiolegacy.app`
Display name: `EthioLegacy`

## Very important
- This is a packaging foundation, **not a completed or tested APK/AAB**.
- The source HTML is preserved, not comprehensively modernized in this package. A safe visual modernization pass should be applied to the existing screens after reviewing and testing this exact source.
- Firebase backend configuration and user accounts are not migrated or replaced by this wrapper.
- Voice/video calling in a WebView may need native camera/microphone permissions and WebRTC testing on real devices. Do not assume calling works until tested across separate Wi-Fi/mobile networks.
- Before public release, verify Firebase security rules, privacy policy, data safety disclosures, account deletion, notification behavior, and Google Play requirements.
- Keep a backup of your original repository. Do not overwrite your live GitHub project until the new build passes tests.

## Source preservation
The original file was copied byte-for-byte into `www/index.html`. The wrapper files are separate so the existing web project can remain untouched.
