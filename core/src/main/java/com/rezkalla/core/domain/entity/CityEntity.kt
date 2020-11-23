package com.rezkalla.core.domain.entity

data class CityEntity (val country:String,val name:String ,val id:Int , val coordinate: CoordinateEntity)
data class CoordinateEntity(val longitude :Double, val latitude:Double)
