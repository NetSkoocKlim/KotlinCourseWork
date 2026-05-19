package com.example.kotlincoursework.data.repository


import com.example.kotlincoursework.data.mapper.toCityWeather
import com.example.kotlincoursework.data.remote.api.CityApiService
import com.example.kotlincoursework.data.remote.api.WeatherApiService
import com.example.kotlincoursework.domain.model.CityWeather
import com.example.kotlincoursework.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(
    private val cityApi: CityApiService,
    private val weatherApi: WeatherApiService
) : WeatherRepository {

    override suspend fun getWeatherForCity(cityName: String): Result<CityWeather> {
        return withContext(Dispatchers.IO) {
            runCatching {
                val cityList = cityApi.getCityData(cityName)
                val cityDto = cityList.firstOrNull() ?: throw Exception("Город не найден")

                val weatherDto = weatherApi.getWeatherData(
                    lat = cityDto.latitude,
                    lon = cityDto.longitude
                )

                cityDto.toCityWeather(weatherDto)
            }
        }
    }
}