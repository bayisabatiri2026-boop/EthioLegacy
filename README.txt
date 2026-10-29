EthioLegacy — Auth UI Fix

Included: index.html with robust show/hide password buttons, improved sign-up/sign-in handling, and an automatically generated invite code saved to the user profile on email registration. Existing app sections are retained.

Important authentication limitation:
- This version uses Firebase Email/Password for actual sign-up and sign-in.
- Although the field label says Email / phone number, phone-number sign-in is NOT active yet; Firebase Phone Authentication requires an SMS OTP and reCAPTCHA flow. The page now explains this instead of falsely accepting a phone number as an email.
- Invite codes are generated from the new user's Firebase UID (EL + UID characters) and saved in Firestore when profile rules allow it.

Deploy/testing:
1. Upload index.html to your existing GitHub Pages repository, replacing the old index.html after keeping a backup.
2. In Firebase Console > Authentication > Sign-in method, enable Email/Password.
3. In Firebase Console > Authentication > Settings > Authorized domains, add your GitHub Pages domain.
4. Test using HTTPS and Wi-Fi/mobile data.

Note: A successful live Firebase sign-up/sign-in cannot be fully verified without access to your Firebase project runtime and its current security rules.
