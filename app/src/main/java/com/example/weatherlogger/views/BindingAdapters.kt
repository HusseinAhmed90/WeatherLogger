package com.example.weatherlogger.views

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherlogger.R
import com.example.weatherlogger.core.data.WeatherModel
import com.example.weatherlogger.views.list.WeatherApiStatus
import com.example.weatherlogger.views.list.WeatherListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<WeatherModel>?) {
    val adapter = recyclerView.adapter as WeatherListAdapter
    adapter.submitList(data)
}

@BindingAdapter("weatherApiStatus")
fun bindStatus(statusImgView: ImageView, status: WeatherApiStatus?) {
    when (status) {
        WeatherApiStatus.LOADING -> {
            statusImgView.visibility = View.VISIBLE
            statusImgView.setImageResource(R.drawable.loading_animation)
        }
        WeatherApiStatus.ERROR -> {
            statusImgView.visibility = View.VISIBLE
            statusImgView.setImageResource(R.drawable.ic_connection_error)
        }
        WeatherApiStatus.DONE -> {
            statusImgView.visibility = View.GONE
        }
    }
}






