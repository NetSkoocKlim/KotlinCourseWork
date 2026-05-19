package com.example.kotlincoursework.presentation.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import com.example.kotlincoursework.presentation.weather.components.CitySelector
import com.example.kotlincoursework.presentation.weather.components.CurrentWeatherSection
import com.example.kotlincoursework.presentation.weather.components.EmptyState
import com.example.kotlincoursework.presentation.weather.components.ErrorState
import com.example.kotlincoursework.presentation.weather.components.HourlyForecastSection
import com.example.kotlincoursework.presentation.weather.components.LoadingState
import com.example.kotlincoursework.presentation.weather.components.ScreenHeader
import com.example.kotlincoursework.presentation.weather.state.CityOption
import com.example.kotlincoursework.presentation.weather.state.WeatherUiState

@Composable
fun WeatherScreen(
    state: WeatherUiState,
    onCitySelected: (CityOption) -> Unit,
    onLoadWeather: () -> Unit,
    onRetry: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 24.dp,
                end = 16.dp,
                bottom = 32.dp
            ),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item { ScreenHeader() }

            item {
                CitySelector(
                    availableCities = state.availableCities,
                    selectedCity = state.selectedCity,
                    onCitySelected = onCitySelected,
                    onLoadWeather = onLoadWeather,
                    isLoading = state.isLoading
                )
            }

            when {
                state.isLoading -> {
                    item { LoadingState() }
                }

                state.errorMessage != null -> {
                    item {
                        ErrorState(
                            message = state.errorMessage,
                            onRetry = onRetry
                        )
                    }
                }

                state.weatherData != null -> {
                    item {
                        CurrentWeatherSection(weather = state.weatherData)
                    }
                    item {
                        HourlyForecastSection(forecasts = state.weatherData.forecasts.take(12))
                    }
                }

                else -> {
                    item { EmptyState() }
                }
            }
        }
    }
}
