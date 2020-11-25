package com.rezkalla.mobileassignment.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rezkalla.core.domain.usecase.FilterCitiesUseCase
import com.rezkalla.mobileassignment.model.City
import com.rezkalla.mobileassignment.model.mapper.CityMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CitiesViewModel @Inject constructor(
    private val getCitiesUseCase: FilterCitiesUseCase,
    private val mapper: CityMapper
) : ViewModel() {

    val citiesLiveData = MutableLiveData<List<City>>()

    fun getCities(word: String = "") {
        viewModelScope.launch {
          filter(word)
        }
    }

    private suspend fun filter(word: String) = withContext(Dispatchers.Default) {
        val cities = getCitiesUseCase(word).map {
            mapper.from(it)
        }
        citiesLiveData.postValue(cities)
    }

}