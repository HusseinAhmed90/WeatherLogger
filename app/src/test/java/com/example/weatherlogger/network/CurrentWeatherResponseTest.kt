package com.example.weatherlogger.network

import com.example.weatherlogger.core.data.WeatherModel
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class CurrentWeatherResponseTest {

    private var mainWeatherResponse: MainWeatherResponse? = null
    private var response: CurrentWeatherResponse? = null
    private var weatherModel: WeatherModel? = null

    @Before
    fun init() {
        mainWeatherResponse = MainWeatherResponse(
            "296.57", "296.64", "296.16",
            "296.57", "1015", "64"
        )
        response = CurrentWeatherResponse(mainWeatherResponse!!)
        weatherModel = response?.getWeatherModel()
    }

    @Test
    fun getWeatherModel() {
        assertEquals("296.57", weatherModel?.temp)
        assertEquals("296.16", weatherModel?.temp_min)
        assertEquals("296.57", weatherModel?.temp_max)
        assertEquals("1015", weatherModel?.pressure)
        assertEquals("64", weatherModel?.humidity)
    }

    @Test
    fun getCurrentDate() {
        assertEquals(weatherModel?.date, response?.getCurrentDate())
    }
}