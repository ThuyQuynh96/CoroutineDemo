package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.ui.base.BaseActivity
import com.example.myapplication.ui.base.BaseViewModel
import com.example.myapplication.ui.base.BaseViewModelFactory
import com.example.myapplication.ui.base.addFragment
import com.example.myapplication.data.response.ConsolidatedResponse
import com.example.myapplication.data.response.ParentResponse
import com.example.myapplication.data.remote.ApiClient
import com.example.myapplication.data.repository.Repository
import com.example.myapplication.ui.base.search.SearchFragment
import com.example.myapplication.ui.base.weather.WeatherAppFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(R.id.flContainerMain, SearchFragment(), SearchFragment::class.simpleName)
    }
}