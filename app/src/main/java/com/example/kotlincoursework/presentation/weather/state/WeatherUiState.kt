package com.example.kotlincoursework.presentation.weather.state

import com.example.kotlincoursework.domain.model.CityWeather

data class WeatherUiState(
    val availableCities: List<CityOption> = CityCatalog.cities,
    val selectedCity: CityOption = CityCatalog.cities.first(),
    val isLoading: Boolean = false,
    val isInitial: Boolean = true,
    val weatherData: CityWeather? = null,
    val errorMessage: String? = null
)
