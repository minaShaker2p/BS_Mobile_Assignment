package com.rezkalla.core.data.repository

import com.rezkalla.core.domain.entity.CityEntity
import com.rezkalla.core.domain.repository.CitiesRepository

class CitiesRepositoryImpl constructor(private val repository: CitiesRepository) : CitiesRepository{
    override fun getCities(): List<CityEntity> {
        return repository.getCities()
    }
}