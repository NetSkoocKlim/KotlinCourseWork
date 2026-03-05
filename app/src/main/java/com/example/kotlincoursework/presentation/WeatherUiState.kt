package com.example.kotlincoursework.presentation

import com.example.kotlincoursework.domain.model.CityWeather

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weatherData: CityWeather? = null,
    val errorMessage: String? = null
)