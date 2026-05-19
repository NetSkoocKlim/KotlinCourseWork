package com.example.kotlincoursework.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoursework.domain.usecase.GetWeatherUseCase
import com.example.kotlincoursework.presentation.weather.state.CityOption
import com.example.kotlincoursework.presentation.weather.state.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    fun onCitySelected(city: CityOption) {
        _uiState.update { currentState ->
            currentState.copy(selectedCity = city)
        }
    }

    fun loadWeather() {
        val selectedCity = _uiState.value.selectedCity

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            val result = getWeatherUseCase(selectedCity.apiName)

            result.onSuccess { data ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isInitial = false,
                        weatherData = data.copy(cityName = selectedCity.russianName),
                        errorMessage = null
                    )
                }
            }.onFailure { error ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isInitial = false,
                        weatherData = null,
                        errorMessage = error.message
                    )
                }
            }
        }
    }

    fun retry() {
        loadWeather()
    }
}
