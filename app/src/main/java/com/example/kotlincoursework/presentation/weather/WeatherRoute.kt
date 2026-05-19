package com.example.kotlincoursework.presentation.weather

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.kotlincoursework.presentation.weather.state.WeatherUiState

@Composable
fun WeatherRoute(viewModel: WeatherViewModel) {
    val state: WeatherUiState by viewModel.uiState.collectAsState()

    WeatherScreen(
        state = state,
        onCitySelected = viewModel::onCitySelected,
        onLoadWeather = viewModel::loadWeather,
        onRetry = viewModel::retry
    )
}
