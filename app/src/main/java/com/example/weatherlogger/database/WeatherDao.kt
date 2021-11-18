package com.example.weatherlogger.database

import androidx.room.*
import com.example.weatherlogger.core.data.WeatherModel

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeather(item: WeatherModel)

    @Delete
    suspend fun deleteWeatherData(item: WeatherModel)

    @Query("SELECT * FROM weather_table ORDER BY id DESC")
    suspend fun getAllWeatherData(): List<WeatherModel>

}