package com.example.myapplication.data.remote

import com.example.myapplication.data.response.ConsolidatedResponse
import com.example.myapplication.data.response.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import kotlin.collections.ArrayList

interface ApiService {

    @GET("location/{woeid}/{date}/")
    suspend fun getLocationDay(
        @Path("woeid") woeid: Int, @Path("date") date: String
    ): Response<ArrayList<ConsolidatedResponse>>

    @GET("location/search/")
    suspend fun getLocationSearch(@Query("query") query: String): Response<SearchResponse>

    @GET("location/search/")
    suspend fun getLocationSearchLat(@Query("lattlong") lattlong: Float): Response<SearchResponse>
}