package com.example.myapplication.data.modun

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "locationTable")
data class Location(
    val location_type: String,
    @PrimaryKey val id: String,
    val date: Date,
    val weather_state_name: String,
    val the_temp: Float
)