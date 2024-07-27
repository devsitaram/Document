package com.sitaram.document.utils.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

object ThemeManager {

    val isDarkTheme by mutableStateOf(false)

    fun toggleTheme() {
        isDarkTheme != isDarkTheme
    }
}