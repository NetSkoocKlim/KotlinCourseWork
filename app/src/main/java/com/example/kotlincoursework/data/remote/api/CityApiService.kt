package com.example.kotlincoursework.data.remote.api

import com.example.kotlincoursework.data.remote.dto.CityDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApiService {
    @GET("city")
    suspend fun getCityData(
        @Query("name") cityName: String
    ): List<CityDto>
}