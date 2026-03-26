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
    val availableCities = remember { CityCatalog.cities }
    var isMenuExpanded by remember { mutableStateOf(false) }
    var selectedCity by remember { mutableStateOf(availableCities.first()) }


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
        Text(
            text = "Выберите город",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = { isMenuExpanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(selectedCity.russianName)
            }

            DropdownMenu(
                expanded = isMenuExpanded,
                onDismissRequest = { isMenuExpanded = false }
            ) {
                availableCities.forEach { city ->
                    DropdownMenuItem(
                        text = { Text(city.russianName) },
                        onClick = {
                            selectedCity = city
                            isMenuExpanded = false
                        }
                    )
                }
            }
        }

        Button(
            onClick = { viewModel.loadWeather(selectedCity) },
            modifier = Modifier.padding(top = 8.dp),
            enabled = !state.isLoading
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
            Text(
                text = "${weather.forecasts.firstOrNull()?.temperature}°C",
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}