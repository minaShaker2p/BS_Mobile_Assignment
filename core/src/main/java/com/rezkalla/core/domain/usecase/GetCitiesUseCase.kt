package com.rezkalla.core.domain.usecase

import com.rezkalla.core.domain.entity.CityEntity
import com.rezkalla.core.domain.repository.CitiesRepository

class GetCitiesUseCase constructor(private val citiesRepository: CitiesRepository) {

    operator fun invoke(): List<CityEntity> {
        return citiesRepository.getCities()
    }
}