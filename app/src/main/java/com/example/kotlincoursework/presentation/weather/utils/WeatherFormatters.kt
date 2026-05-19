package com.example.kotlincoursework.presentation.weather.utils

import kotlin.math.roundToInt

internal fun formatTemperature(temperature: Double): String {
    val rounded = temperature.roundToInt()
    val value = if (rounded > 0) "+$rounded" else rounded.toString()
    return "$value\u00B0C"
}

internal fun formatForecastTime(rawTime: String): String {
    val normalizedTime = rawTime.replace("T", " ")
    val parts = normalizedTime.split(" ")
    if (parts.size < 2) return normalizedTime

    val date = parts[0]
    val time = parts[1].take(5)
    val day = date.substringAfterLast("-")

    return "$day, $time"
}
