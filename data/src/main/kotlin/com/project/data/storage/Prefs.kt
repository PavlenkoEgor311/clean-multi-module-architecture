package com.project.data.storage

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    val mainPrefs: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_MAIN, Context.MODE_PRIVATE)
    }
    var token: String by PrefsDelegate("", mainPrefs)


    companion object {
        private const val PREFS_MAIN = "prefsMain"
    }
}