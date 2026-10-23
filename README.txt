ETHIOLEGACY - MEDIA, CALLING, CONNECTIVITY, SECURITY UPDATE

Included in this update
- Chat attachment button for images, videos, audio and common documents.
- Uploads attachments to Firebase Storage and posts download links/metadata into Firestore chat messages.
- Displays image previews, playable videos and downloadable file links in the chat history.
- Voice/video WebRTC call controls, incoming call flow, and mute/camera toggles.
- Remote audio element for voice calls (audio calls must not depend on a hidden video element).
- Internet available/offline indicator and clearer send/upload errors.
- Privacy/security guidance in Settings and explicit camera/microphone/notification permission flow.

IMPORTANT SETUP
1. Open index.html and replace every PASTE_YOUR_NEW_* value in firebaseConfig with your actual Firebase Web app config.
2. In Firebase Console enable Authentication (Email/Password), create Firestore Database, and enable Firebase Storage.
3. Configure Firestore and Storage rules before deploying. Do NOT use public read/write rules. The app's current chat/group data model needs membership checks added consistently in the client and rules before a production ruleset can be considered secure.
4. For reliable calls across restrictive networks, configure a TURN service as well as STUN. STUN-only calling may fail on some networks. Test with two devices on separate networks.
5. Host the site on HTTPS (Netlify provides HTTPS). Camera/microphone access normally requires a secure context and user permission.
6. Browser notifications while the page is closed require Firebase Cloud Messaging, a service worker, valid web push setup, and permission. In-app notifications alone are not background push notifications.
7. This app does NOT implement end-to-end encryption. Firebase transport/storage protections are not the same as end-to-end encryption. Do not promise private end-to-end encrypted chats.
8. Device contact selection is user-initiated and browser-dependent; it does not silently upload the phone address book.
9. Android APK packaging still requires a native Android/Capacitor project build and testing. This ZIP does not contain a compiled APK.

LIMITATIONS / TESTING
- Maximum attachment size in the UI is 50 MB; Firebase Storage quota, billing plan, and security rules can impose lower limits.
- The current basic calling code is peer-to-peer WebRTC signaling via Firestore. Production calling requires robust call cleanup, TURN, error handling, and testing on real networks.
- Group voice/video calls, end-to-end encryption, blocking/reporting, account deletion, and background push notifications are not fully implemented by this update.
- Internet indicator reports device network status only; it does not guarantee Firebase availability.
