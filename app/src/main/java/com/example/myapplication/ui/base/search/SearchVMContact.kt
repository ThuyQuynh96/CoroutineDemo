package com.example.myapplication.ui.base.search

import com.example.myapplication.data.response.SearchResponse

interface SearchVMContact {
    fun getListItem(): List<SearchResponse>
}

