package com.example.weatherlogger.network

import com.example.weatherlogger.core.data.WeatherModel
import java.text.SimpleDateFormat
import java.util.*

data class CurrentWeatherResponse (
    val main: MainWeatherResponse
) {

    fun getWeatherModel() = WeatherModel(
        getCurrentDate(),
        main.temp,
        main.temp_min,
        main.temp_max,
        main.pressure,
        main.humidity
    )

    fun getCurrentDate():String{
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        return sdf.format(Date())
    }
}

data class MainWeatherResponse (
    val temp: String,
    val feels_like: String,
    val temp_min: String,
    val temp_max: String,
    val pressure: String,
    val humidity: String
)