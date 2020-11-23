package com.rezkalla.core.domain.utils

import com.rezkalla.core.domain.entity.CityEntity
import com.rezkalla.core.domain.entity.CoordinateEntity

class TestDataGenerator {
    companion object {
        fun getTestData(): List<CityEntity> {
            return listOf(
                CityEntity("UA", "Hurzuf", 707860, CoordinateEntity(34.283333, 44.549999)),
                CityEntity("RU", "Novinki", 519188, CoordinateEntity(37.666668, 55.683334)),
                CityEntity("NP", "Gorkhā", 1283378, CoordinateEntity(84.633331, 28.0))
            )
        }
    }
}