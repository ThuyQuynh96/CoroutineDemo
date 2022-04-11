package com.example.myapplication.data.modun

import androidx.lifecycle.LiveData

interface DataSource {
    suspend fun addLocation(location: Location)
    fun getLocation(): LiveData<List<Location>?>
    suspend fun updateLocation(location: Location)
    suspend fun deleteLocation(location: Location)
}