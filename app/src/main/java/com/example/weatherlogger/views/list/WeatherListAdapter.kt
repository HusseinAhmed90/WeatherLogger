package com.example.weatherlogger.views.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherlogger.core.data.WeatherModel
import com.example.weatherlogger.databinding.WeatherListItemBinding

class WeatherListAdapter(val clickListener: DeleteItemListener) : ListAdapter<WeatherModel, WeatherListAdapter.WeatherViewHolder>(DiffCallback) {

    class WeatherViewHolder(private var binding: WeatherListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherModel, clickListener: DeleteItemListener) {
            binding.item = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<WeatherModel>() {
        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem.date == newItem.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(WeatherListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class DeleteItemListener (val clickListener: (item: WeatherModel) -> Unit) {
        fun onClick(item: WeatherModel) = clickListener(item)
    }
}