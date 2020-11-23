package com.rezkalla.mobileassignment.presentation

import androidx.lifecycle.ViewModel
import com.rezkalla.core.domain.usecase.GetCitiesUseCase
import com.rezkalla.mobileassignment.model.City
import com.rezkalla.mobileassignment.model.mapper.CityMapper
import javax.inject.Inject

class CitiesViewModel @Inject constructor(
    private val getCitiesUseCase: GetCitiesUseCase,
    private val mapper: CityMapper
) :ViewModel(){

    private var cities = mutableListOf<City>()
    fun getCities() {
     cities.addAll(
         getCitiesUseCase().map {
             mapper.from(it)
         }
     )
    }
}