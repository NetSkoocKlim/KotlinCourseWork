package com.example.kotlincoursework.domain.repository


import com.example.kotlincoursework.domain.model.CityWeather

interface WeatherRepository {
    suspend fun getWeatherForCity(cityName: String): Result<CityWeather>
}