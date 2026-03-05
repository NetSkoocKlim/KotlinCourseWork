package com.example.kotlincoursework.data.remote.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class WeatherDto(
    val latitude: Double,
    val longitude: Double,
    @SerialName("hourly")
    val hourlyData: HourlyDataDto
)

@Serializable
data class HourlyDataDto(
    val time: List<String>,
    @SerialName("temperature_2m")
    val temperatures: List<Double>
)