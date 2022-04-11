package com.example.myapplication.ui.base.search

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.response.SearchResponse

class SearchViewModel : ViewModel(), SearchVMContact {

    private var listItem: List<SearchResponse> = mutableListOf()

    override fun getListItem(): List<SearchResponse> = listItem
}