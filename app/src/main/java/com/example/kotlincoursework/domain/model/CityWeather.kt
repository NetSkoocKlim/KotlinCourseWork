package com.example.kotlincoursework.domain.model

data class CityWeather(
    val cityName: String,
    val latitude: Double,
    val longitude: Double,
    val forecasts: List<HourForecast>
)