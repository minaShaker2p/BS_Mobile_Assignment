package com.rezkalla.core.data.repository

import com.rezkalla.core.data.source.CitiesLocalDataSource
import com.rezkalla.core.domain.entity.CityEntity
import com.rezkalla.core.domain.repository.CitiesRepository

class CitiesRepositoryImpl constructor(private val localDataSource: CitiesLocalDataSource) : CitiesRepository{
    override fun getCities(): List<CityEntity> {
        return localDataSource.getCities()
    }
}