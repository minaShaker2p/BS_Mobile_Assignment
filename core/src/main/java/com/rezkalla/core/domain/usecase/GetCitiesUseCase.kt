package com.rezkalla.core.domain.usecase

import com.rezkalla.core.domain.entity.CityEntity
import com.rezkalla.core.domain.repository.CitiesRepository
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(private val citiesRepository: CitiesRepository) {

    operator fun invoke(): List<CityEntity> {
        return citiesRepository.getCities()
    }
}