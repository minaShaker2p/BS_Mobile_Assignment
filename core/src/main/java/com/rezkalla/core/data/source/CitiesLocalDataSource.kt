package com.rezkalla.core.data.source

import com.rezkalla.core.domain.entity.CityEntity

interface CitiesLocalDataSource {
    fun getCities() :List<CityEntity>
}