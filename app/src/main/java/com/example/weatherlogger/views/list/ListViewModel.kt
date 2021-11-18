package com.example.weatherlogger.views.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherlogger.core.data.WeatherModel
import com.example.weatherlogger.database.RoomWeatherDataSource
import com.example.weatherlogger.network.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

enum class WeatherApiStatus {LOADING, ERROR, DONE}

class ListViewModel(application: Application) : AndroidViewModel(application){

    private var repo: RoomWeatherDataSource = RoomWeatherDataSource(application)

    private val _status = MutableLiveData<WeatherApiStatus>()
    val status: LiveData<WeatherApiStatus>
        get() = _status

    private val _weatherList = MutableLiveData<List<WeatherModel>>()
    val weatherList: LiveData<List<WeatherModel>>
        get() = _weatherList

    init {
        _status.value = WeatherApiStatus.DONE
        getAllWeatherData()
    }

    private fun getAllWeatherData() {
        viewModelScope.launch {
            val weatherList = repo.getAllSavedWeatherData()
            withContext(Dispatchers.Main){
                _weatherList.value = weatherList
            }
        }
    }

    fun fabClicked() {
        getCurrentWeather()
    }

    private fun getCurrentWeather() {
        _status.value = WeatherApiStatus.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val currentWeatherData = WeatherApi.retrofitService.getCurrentWeather().getWeatherModel()
                repo.addCurrentWeather(currentWeatherData)

                withContext(Dispatchers.Main){
                    try {
                        _status.value = WeatherApiStatus.DONE
                        println("Current Weather ## : ${currentWeatherData.date} - ${currentWeatherData.temp}")
                        getAllWeatherData()
                    } catch (t: Throwable) {
                        _status.value = WeatherApiStatus.ERROR
                        println("Error#$ : ${t.message}")
                    }
                }
            } catch (t: Throwable) {
                _status.value = WeatherApiStatus.ERROR
                println("Error#$ : ${t.message}")
            }
        }
    }

    fun onDeleteItemClicked(item: WeatherModel) {
        _status.value = WeatherApiStatus.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            repo.delete(item)
            withContext(Dispatchers.Main){
                try {
                    _status.value = WeatherApiStatus.DONE
                    getAllWeatherData()
                } catch (t: Throwable) {
                    _status.value = WeatherApiStatus.ERROR
                }
            }
        }
    }

}