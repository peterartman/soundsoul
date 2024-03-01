package com.finalyearproject.soundsoul.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.finalyearproject.soundsoul.utils.safeLet

fun toast(context: Context?, message: String?, duration: Int = Toast.LENGTH_SHORT) {
    safeLet(context, message, duration) { safeContext, safeMessage, safeDuration ->
        (safeContext as? Activity)?.runOnUiThread {
            Toast.makeText(safeContext, safeMessage, safeDuration).show()
        }
    }
}