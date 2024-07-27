package com.sitaram.document.helper

import android.content.Context
import android.content.SharedPreferences
import com.sitaram.document.utils.urls.CommonUrl

class UserInterceptors(context: Context) {

    // Shared preferences instance
    private val sharedPreferences = context.getSharedPreferences("file_record_preferences", Context.MODE_PRIVATE)

    // return the share shared preference instance
    private fun getPreferenceInstance(): SharedPreferences {
        return sharedPreferences
    }

    // Shared preferences editor object
    fun getPreInstEditor(): SharedPreferences.Editor {
        return getPreferenceInstance().edit()
    }

    // Get app install instance
    fun installApp(): String {
        return sharedPreferences.getString("appInstallation", "") ?: ""
    }

    // Save FCM Token
    fun getFcmDeviceToke(): String {
        return sharedPreferences.getString("fcmDeviceToken", "") ?: ""
    }

    // Save FCM Token
    fun getSystemToke(): String {
        return sharedPreferences.getString("systemToken", "") ?: ""
    }

    // Save new email
    fun getRememberEmail(): String {
        return sharedPreferences.getString("email", "") ?: ""
    }

    // Save new email
    fun getThemeMode(): String {
        return sharedPreferences.getString(CommonUrl.DARK_LIGHT_MODE, "") ?: ""
    }
}