package com.rezkalla.mobileassignment.datasource

import android.app.Application
import com.rezkalla.core.data.source.CitiesLocalDataSource
import com.rezkalla.core.domain.entity.CityEntity
import com.rezkalla.core.domain.entity.CoordinateEntity
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset


class CitiesLocalDataSourceImpl(private val application: Application) :
    CitiesLocalDataSource {
    private var jsonString: String? = null

    private fun parseJsonString(jsonString: String): List<CityEntity> {
        val citiesItems = mutableListOf<CityEntity>()
        val newsArray = JSONArray(jsonString)

        newsArray.forEach { newsObject ->
            val country = newsObject.getString("country")
            val name = newsObject.getString("name")
            val id = newsObject.getInt("_id")
            val coordinate = newsObject.getJSONObject("coord")
            val latitude = coordinate.getDouble("lon")
            val longitude = coordinate.getDouble("lat")

            citiesItems.add(
                CityEntity(
                    country = country,
                    name = name,
                    id = id,
                    coordinate = CoordinateEntity(longitude, latitude)
                )
            )
        }
        return citiesItems
    }

    override fun getCities(): List<CityEntity> {
        val inputStream = application.assets.open("cities.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        jsonString = buffer.toString(Charset.defaultCharset())
        jsonString?.let {
            return parseJsonString(it)
        }
        return emptyList()
    }
}


fun JSONArray.forEach(jsonObject: (JSONObject) -> Unit) {
    for (index in 0 until this.length()) jsonObject(this[index] as JSONObject)
}
