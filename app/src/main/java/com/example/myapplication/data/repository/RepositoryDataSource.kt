package com.example.myapplication.data.repository

import com.example.myapplication.data.response.ConsolidatedResponse
import com.example.myapplication.data.response.SearchResponse
import retrofit2.Response
import kotlin.collections.ArrayList

interface RepositoryDataSource {

    suspend fun getLocationDay(
        woeid: Int,
        date: String
    ): Response<ArrayList<ConsolidatedResponse>>

    suspend fun getLocationSearch(
        query: String
    ): Response<SearchResponse>
}