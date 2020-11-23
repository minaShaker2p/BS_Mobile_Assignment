package com.rezkalla.mobileassignment.model

data class City(val country: String, val name: String, val coordinate: Coordinate)
data class Coordinate(val longitude: Double, val latitude: Double)
