package com.example.kotlincoursework.data.mapper

import com.example.kotlincoursework.data.remote.dto.CityDto
import com.example.kotlincoursework.data.remote.dto.WeatherDto
import com.example.kotlincoursework.domain.model.CityWeather
import com.example.kotlincoursework.domain.model.HourForecast

fun WeatherDto.toHourForecastList(): List<HourForecast> {
    return hourlyData.time.mapIndexed { index, time ->
        HourForecast(
            time = time.replace("T", " "),
            temperature = hourlyData.temperatures[index]
        )
    }
}

fun CityDto.toCityWeather(weatherDto: WeatherDto): CityWeather {
    return CityWeather(
        cityName = this.name,
        latitude = this.latitude,
        longitude = this.longitude,
        forecasts = weatherDto.toHourForecastList()
    )
}