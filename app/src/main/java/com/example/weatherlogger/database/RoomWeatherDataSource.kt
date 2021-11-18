package com.example.weatherlogger.database

import android.content.Context
import com.example.weatherlogger.core.data.WeatherModel
import com.example.weatherlogger.core.repository.WeatherDataSource

class RoomWeatherDataSource( context: Context): WeatherDataSource {

    private val weatherDao = DatabaseService.getInstance(context).weatherDao()

    override suspend fun addCurrentWeather(item: WeatherModel) = weatherDao.addWeather(item)

    override suspend fun delete(item: WeatherModel) = weatherDao.deleteWeatherData(item)

    override suspend fun getAllSavedWeatherData(): List<WeatherModel> = weatherDao.getAllWeatherData()


}