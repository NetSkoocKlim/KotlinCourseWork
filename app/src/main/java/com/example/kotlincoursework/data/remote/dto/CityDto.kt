package com.example.kotlincoursework.data.remote.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class CityDto(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val state: String? = null
)