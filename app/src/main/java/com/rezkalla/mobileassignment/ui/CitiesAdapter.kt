package com.rezkalla.mobileassignment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rezkalla.mobileassignment.R
import com.rezkalla.mobileassignment.model.City
import kotlinx.android.synthetic.main.item_city.view.*
import javax.inject.Inject

class CitiesAdapter @Inject constructor() : RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {
    private val cities = mutableListOf<City>()

    fun updateCities(list: List<City>) {
        cities.clear()
        cities.addAll(list)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityViewHolder(view)
    }

    override fun getItemCount() = cities.size

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cities[position])
    }


    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(city: City) {
            itemView.tvTitle.text = "${city.name},${city.country}"
            itemView.tvSubTitle.text = "${city.coordinate.latitude},${city.coordinate.longitude}"
        }
    }

}