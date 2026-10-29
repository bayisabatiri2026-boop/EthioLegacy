EthioLegacy – calling network fixes

This update improves WebRTC ICE candidate handling, remote media playback, connection-state diagnostics, and candidate-listener cleanup. It does not change the rest of the app intentionally.

IMPORTANT: Voice/video calls between different Wi-Fi/mobile-data networks require a working TURN relay, Firebase Firestore signaling access, and HTTPS. This HTML currently contains Metered TURN server credentials in the client code. I cannot verify those credentials or your Firebase rules from here, and no live two-phone call test has been performed. If calls still fail across networks, create/verify a TURN credential in your TURN provider account and replace the username/credential for all three Metered entries in index.html. Do not publish long-lived secret credentials in a public GitHub repository; use a secure credential service for production.

Firebase Firestore must allow authenticated call documents and their subcollections: calls/{callId}, calls/{callId}/offerCandidates/{candidateId}, and calls/{callId}/answerCandidates/{candidateId}. The caller and receiver must both be signed in and the receiver must be an EthioLegacy user.

Deploy the folder to an HTTPS host (GitHub Pages is HTTPS). Test with two phones at different places, one on Wi-Fi and one on mobile data. Keep the app open during testing; this web app does not guarantee incoming calls while closed/backgrounded.
