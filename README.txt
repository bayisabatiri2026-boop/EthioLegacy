ETHIOLEGACY — CALLING UPDATE PACKAGE

FILES
- index.html: existing EthioLegacy app with targeted WebRTC calling updates.
- manifest.webmanifest: installable web-app settings.
- sw.js: basic app-shell service worker for HTTPS hosting.
- icons/: app icons.

CALLING CODE UPDATES
- Expanded TURN relay transport choices (UDP, TCP and TLS) while retaining the TURN credentials already present in the supplied source.
- Added ICE connection-state and ICE-server diagnostics.
- Improved mobile inline video playback attributes.
- Kept the existing app layout and non-calling features in place.

IMPORTANT — EXTERNAL SETUP IS STILL REQUIRED
1. Upload the contents of this folder to an HTTPS host (GitHub Pages, Netlify, or your own HTTPS server).
2. The Metered TURN username/password inherited from the supplied HTML have NOT been verified. If expired, calls across different networks can still fail. Replace them with active credentials from your TURN provider. Do not publish long-lived TURN secrets in a public GitHub repository; use time-limited credentials issued by a backend where possible.
3. Firebase must be configured correctly. Firestore rules must allow authenticated caller and receiver to read/update their call document and read/write its offerCandidates and answerCandidates subcollections.
4. If Firestore reports a missing composite index for receiverId + status, create the index using the Firebase error link.
5. Test using two signed-in accounts on two separate devices, one on Wi-Fi and one on mobile data. Grant microphone/camera permissions.

LIMITATION
This is a code package, not a verified live call test. The code cannot make calls succeed without valid TURN credentials, correct Firebase rules/indexes, HTTPS, and working device permissions. The package does not contain a private TURN server or Firebase backend.

GITHUB PAGES
Upload the files and folders in this package to the repository root (keep the same folder structure), then enable GitHub Pages for the branch/folder containing index.html.
