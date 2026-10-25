EthioLegacy installable web app (PWA)

UPLOAD THESE FILES to the ROOT of your existing GitHub Pages repository:
- index.html
- manifest.webmanifest
- sw.js
- icons/ (folder with icon-192.png and icon-512.png)

Keep the site served over HTTPS. Once GitHub Pages has redeployed, open your website in Chrome on Android, tap the browser menu (three dots), and choose "Install app" or "Add to Home screen".

Important:
- This is an installable PWA package, NOT a compiled Android APK.
- Installing it does not fix Firebase configuration or calling by itself.
- The source copied into this package is the currently available EthioLegacy index.html. Replace Firebase placeholders with the real Web app config before expecting authentication/calling to work.
- Offline caching is only for the app shell; messaging, file uploads, and calls still require internet and working Firebase services.
