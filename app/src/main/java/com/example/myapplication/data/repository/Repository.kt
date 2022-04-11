package com.example.myapplication.data.repository

import com.example.myapplication.data.response.ConsolidatedResponse
import com.example.myapplication.data.response.SearchResponse
import com.example.myapplication.data.remote.ApiClient
import com.example.myapplication.data.remote.ApiService
import retrofit2.Response
import kotlin.collections.ArrayList


class Repository constructor(private val apiService: ApiService = ApiClient.getApiService()) :
    RepositoryDataSource {

    override suspend fun getLocationDay(
        woeid: Int,
        date: String
    ): Response<ArrayList<ConsolidatedResponse>> {
        return apiService.getLocationDay(woeid, date)
    }

    override suspend fun getLocationSearch(query: String): Response<SearchResponse> =
        apiService.getLocationSearch(query)

}