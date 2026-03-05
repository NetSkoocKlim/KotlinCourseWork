package com.example.kotlincoursework.data.remote.api

import com.example.kotlincoursework.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("forecast")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double,
        @Query("hourly") hourly: String = "temperature_2m",
        @Query("forecast_days") days: Int = 16
    ): WeatherDto
}