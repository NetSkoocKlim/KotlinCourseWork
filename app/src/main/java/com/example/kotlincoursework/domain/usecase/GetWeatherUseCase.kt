package com.example.kotlincoursework.domain.usecase


import com.example.kotlincoursework.domain.model.CityWeather
import com.example.kotlincoursework.domain.repository.WeatherRepository

class GetWeatherUseCase(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(cityName: String): Result<CityWeather> {
        if (cityName.isBlank()) {
            return Result.failure(Exception("Название города не может быть пустым"))
        }
        return repository.getWeatherForCity(cityName)
    }
}