package com.example.weatherlogger.core.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherModel(
    val date: String,
    val temp: String,
    val temp_min: String,
    val temp_max: String,
    val pressure: String,
    val humidity: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)