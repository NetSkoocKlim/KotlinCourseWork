package com.example.kotlincoursework.presentation


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val state by viewModel.uiState.collectAsState()
    var cityInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top=40.dp,
                start=16.dp,
                end=16.dp,
                bottom=40.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = cityInput,
            onValueChange = { cityInput = it },
            label = { Text("Введите город") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.loadWeather(cityInput) },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Узнать погоду")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (state.isLoading) {
            CircularProgressIndicator()
        }

        state.errorMessage?.let {
            Text(text = "Ошибка: $it", color = MaterialTheme.colorScheme.error)
        }

        state.weatherData?.let { weather ->
            Text(text = "Город: ${weather.cityName}", style = MaterialTheme.typography.headlineMedium)
            val currentTemp = weather.forecasts.firstOrNull()?.temperature ?: 0.0
            Text(text = "$currentTemp°C", style = MaterialTheme.typography.displayLarge)
        }
    }
}