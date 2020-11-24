package com.rezkalla.mobileassignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(val country: String, val name: String, val coordinate: Coordinate) : Parcelable

@Parcelize
data class Coordinate(val longitude: Double, val latitude: Double) : Parcelable
