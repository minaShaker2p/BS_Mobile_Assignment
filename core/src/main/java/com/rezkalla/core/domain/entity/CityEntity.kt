package com.rezkalla.core.domain.entity

data class CityEntity (val country:String,val name:String ,val id:Int , val coordinate: Coordinate)
data class Coordinate(val longitude :Double,val latitude:Double)
