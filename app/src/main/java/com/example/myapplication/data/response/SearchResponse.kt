package com.example.myapplication.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("title") val title: String,
    @SerialName("location_type") val location_type: String,
    @SerialName("latt_long") val latt_long: Float,
    @SerialName("distance") val distance: Int
)
