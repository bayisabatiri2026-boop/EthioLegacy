EthioLegacy - call audio controls update

Includes the latest available mobile send-arrow/attachment/voice-recording source plus:
- Call playback volume slider (0-100%)
- Optional generated incoming-call tone, with a toggle
- Stops the tone when a call is accepted, rejected, or ended

IMPORTANT LIMITATIONS:
1. This is source code, not a compiled APK.
2. The Firebase configuration in index.html currently contains placeholder values. Replace them with the exact Web app config from your Firebase Console before use. Without this, sign-in, Firestore messages, and Storage uploads will fail.
3. File visibility to another member requires matching chat IDs and correct Firestore/Storage security rules. This source cannot be verified against your live Firebase project without its real configuration and rules.
4. This is not a claim that calls, group calls, push notifications, or uploads are fully tested. WebRTC here is one-to-one only and has STUN but no TURN server; some networks will fail without TURN. Group calls need separate implementation.
5. Browser call tones can be blocked until the user interacts with the page; mobile browser autoplay/permissions differ by device. The volume slider changes remote audio element volume, not Android's hardware volume.
6. Never use open Firebase rules in production. Configure Authentication, Firestore, and Storage rules to restrict access to signed-in members and chat participants.
