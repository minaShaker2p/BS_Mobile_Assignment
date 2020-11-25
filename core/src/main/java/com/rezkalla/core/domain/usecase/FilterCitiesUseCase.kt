package com.rezkalla.core.domain.usecase

import com.rezkalla.core.domain.entity.CityEntity
import com.rezkalla.core.domain.repository.CitiesRepository
import javax.inject.Inject

class FilterCitiesUseCase @Inject constructor(citiesRepository: CitiesRepository) {

    private val cities = mutableListOf<CityEntity>()

    init {
        cities.addAll(citiesRepository.getCities())
    }

    operator fun invoke(word: String = ""): List<CityEntity> {
        return if (word.isNotEmpty()) {
            cities
                .asSequence()
                .filter { city ->
                    city.name.startsWith(word, true)
                }.toList()
        } else
            cities
    }
}