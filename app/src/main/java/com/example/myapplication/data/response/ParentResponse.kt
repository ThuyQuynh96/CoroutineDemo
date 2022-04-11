package com.example.myapplication.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
@Parcelize
data class ParentResponse(
    @SerialName("title") var title: String,
    @SerialName("location_type") val location_type: String,
    @SerialName("latt_long") val latt_long: Float,
    @SerialName("woeid") val woeid: Int,
    @SerialName("time") val date: String,
    @SerialName("sun_rise") val sun_rise: Date,
    @SerialName("sun_set") val sun_set: Date,
    @SerialName("timezone_name") val timezone_name: String,
    val location: Boolean = false
) : Parcelable