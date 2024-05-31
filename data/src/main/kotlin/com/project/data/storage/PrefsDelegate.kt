package com.project.data.storage

import android.content.SharedPreferences
import com.squareup.moshi.JsonAdapter
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PrefsDelegate<T>(
    private val defaultValue: T,
    private val preferences: SharedPreferences
) {
    private var storedValue: T? = null
    operator fun provideDelegate(
        thisRef: Prefs,
        prop: KProperty<*>
    ): ReadWriteProperty<Prefs, T> {
        val key = prop.name
        return object : ReadWriteProperty<Prefs, T> {
            override fun getValue(thisRef: Prefs, property: KProperty<*>): T {
                if (storedValue == null) {
                    @Suppress("UNCHECKED_CAST")
                    storedValue = when (defaultValue) {
                        is Int -> preferences.getInt(key, defaultValue as Int) as T
                        is Long -> preferences.getLong(key, defaultValue as Long) as T
                        is Float -> preferences.getFloat(key, defaultValue as Float) as T
                        is String -> preferences.getString(key, defaultValue as String) as T
                        is Boolean -> preferences.getBoolean(
                            key,
                            defaultValue as Boolean
                        ) as T

                        else -> error("This type can not be stored into Preferences")
                    }
                }
                return storedValue!!
            }

            override fun setValue(thisRef: Prefs, property: KProperty<*>, value: T) {
                with(preferences.edit()) {
                    when (value) {
                        is String -> putString(key, value)
                        is Int -> putInt(key, value)
                        is Boolean -> putBoolean(key, value)
                        is Long -> putLong(key, value)
                        is Float -> putFloat(key, value)
                        else -> error("Only primitive types can be stored into Preferences")
                    }
                    apply()
                }
                storedValue = value
            }
        }
    }
}