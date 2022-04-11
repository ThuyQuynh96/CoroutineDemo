package com.example.myapplication.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourcesResponse(
    @SerialName("title") val title: String,
    @SerialName("url") val url: String
)