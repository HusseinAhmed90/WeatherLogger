package com.example.weatherlogger.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherlogger.core.data.WeatherModel

@Database(entities = [WeatherModel::class], version = 1)
abstract class DatabaseService: RoomDatabase() {

    companion object{

        private const val DATABASE_NAME = "weather_logger.db"
        private var instance: DatabaseService? = null

        private fun create(context: Context): DatabaseService =
            Room.databaseBuilder(context, DatabaseService::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context): DatabaseService =
            (instance ?: create(context)).also { instance = it }

    }

    abstract fun weatherDao(): WeatherDao

}