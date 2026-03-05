package com.example.kotlincoursework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.kotlincoursework.data.remote.RetrofitClient
import com.example.kotlincoursework.data.repository.WeatherRepositoryImpl
import com.example.kotlincoursework.domain.usecase.GetWeatherUseCase
import com.example.kotlincoursework.presentation.WeatherScreen
import com.example.kotlincoursework.presentation.WeatherViewModel
import com.example.kotlincoursework.ui.theme.KotlinCourseWorkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = WeatherRepositoryImpl(
            cityApi = RetrofitClient.cityApi,
            weatherApi = RetrofitClient.weatherApi
        )
        val getWeatherUseCase = GetWeatherUseCase(repository)
        val viewModel = WeatherViewModel(getWeatherUseCase)

        setContent {
            KotlinCourseWorkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherScreen(viewModel = viewModel)
                }
            }
        }
    }
}