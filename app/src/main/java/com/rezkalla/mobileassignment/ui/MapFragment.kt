package com.rezkalla.mobileassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rezkalla.mobileassignment.R
import com.rezkalla.mobileassignment.model.City

class MapFragment : Fragment(), OnMapReadyCallback {

    private var city: City? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMap()
         city = arguments?.getParcelable("city") as? City
    }

    private fun setupMap() {
        val mapFragment: SupportMapFragment? = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        city?.let {
            val latlng = LatLng(it.coordinate.latitude, it.coordinate.longitude)
            val position = CameraPosition.Builder()
                .target(latlng)
                .zoom(15.0f)
                .build()
            googleMap?.animateCamera(CameraUpdateFactory.newCameraPosition(position))
            googleMap?.addMarker(
                MarkerOptions()
                    .position(latlng)
                    .title("${it.name},${it.country}")
            )
        }
    }

}