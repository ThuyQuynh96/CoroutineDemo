package com.example.myapplication.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class ConsolidatedResponse(
    @SerialName("applicable_date") val applicable_date: String,
    @SerialName("weather_state_name") val weather_state_name: String,
    @SerialName("weather_state_abbr") val weather_state_abbr: String,
    @SerialName("wind_speed") val wind_speed: Float,
    @SerialName("wind_direction") val wind_direction: Float,
    @SerialName("wind_direction_compass") val wind_direction_compass: String,
    @SerialName("min_temp") val min_temp: Float,
    @SerialName("max_temp") val max_temp: Float,
    @SerialName("the_temp") val the_temp: Float,
    @SerialName("air_pressure") val air_pressure: Float,
    @SerialName("humidity") val humidity: Float,
    @SerialName("visibility") val visibility: Float,
    @SerialName("predictability") val predictability: Int
) : Parcelable