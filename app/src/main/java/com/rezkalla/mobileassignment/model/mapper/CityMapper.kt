package com.rezkalla.mobileassignment.model.mapper

import com.rezkalla.core.domain.entity.CityEntity
import com.rezkalla.core.domain.entity.CoordinateEntity
import com.rezkalla.mobileassignment.model.City
import com.rezkalla.mobileassignment.model.Coordinate
import javax.inject.Inject

class CityMapper @Inject constructor() : Mapper<City, CityEntity> {
    override fun from(e: CityEntity): City {
        return City(e.country, e.name, Coordinate(e.coordinate.longitude, e.coordinate.latitude))
    }

    override fun to(t: City): CityEntity {
        return CityEntity(t.country, t.name,0, CoordinateEntity(t.coordinate.longitude, t.coordinate.latitude))
    }
}