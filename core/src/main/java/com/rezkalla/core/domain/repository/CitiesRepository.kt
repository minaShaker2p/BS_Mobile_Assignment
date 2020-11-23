package com.rezkalla.core.domain.repository

import com.rezkalla.core.domain.entity.CityEntity

interface CitiesRepository {
    fun getCities(): List<CityEntity>
}