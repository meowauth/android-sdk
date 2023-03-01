package io.meowauth.sampleapp

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MeowFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.w("🎁", "Firebase token: $token")
    }
}
