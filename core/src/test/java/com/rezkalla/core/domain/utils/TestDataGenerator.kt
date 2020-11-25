package com.rezkalla.core.domain.utils

import com.rezkalla.core.domain.entity.CityEntity
import com.rezkalla.core.domain.entity.CoordinateEntity

class TestDataGenerator {
    companion object {
        fun getTestData(): List<CityEntity> {
            return listOf(
                CityEntity("US", "Alabama", 707860, CoordinateEntity(34.283333, 44.549999)),
                CityEntity("US", "Albuquerque", 519188, CoordinateEntity(37.666668, 55.683334)),
                CityEntity("US", "Anaheim", 1283378, CoordinateEntity(84.633331, 28.0)),
                CityEntity("US", "Arizona", 1283378, CoordinateEntity(84.633331, 28.0)),
                CityEntity("AU", "Sydney", 1283378, CoordinateEntity(84.633331, 28.0))
            )
        }
    }
}