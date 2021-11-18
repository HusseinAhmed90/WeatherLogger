package com.example.weatherlogger.core.repository

import com.example.weatherlogger.core.data.WeatherModel

interface WeatherDataSource {

    suspend fun addCurrentWeather(item: WeatherModel)
    suspend fun delete(item: WeatherModel)
    suspend fun getAllSavedWeatherData(): List<WeatherModel>

}