EthioLegacy enhanced web app

Contents:
- index.html: updated interface and app code

Before deployment:
1. Replace the PASTE_YOUR_NEW_* Firebase config placeholders in index.html with the real Firebase web app configuration.
2. Enable Firebase Authentication (Email/Password), Firestore Database, and Firebase Storage.
3. Configure Firestore and Storage security rules for authenticated users. Do not use public write access in production.
4. Deploy the folder/site to Netlify using HTTPS.
5. For true background push notifications on Android, configure Firebase Cloud Messaging and a service worker; this HTML version shows in-app notifications and browser notifications while permitted.
6. Camera/microphone calls need HTTPS, permissions, and working Firestore rules. For reliable calls across restrictive networks, add a TURN server; STUN alone is not enough.

Five UI language options: English, Afaan Oromoo, Amharic, Tigrinya, Arabic. The current language switch translates selected interface labels; full translation of every screen still requires more translation strings.
