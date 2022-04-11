package com.example.myapplication.ui.base.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.response.ConsolidatedResponse
import com.example.myapplication.ui.base.BaseFragment
import com.example.myapplication.data.response.ParentResponse
import com.example.myapplication.databinding.FragmentSearchBinding
import com.example.myapplication.ui.base.addChildFragment
import com.example.myapplication.ui.base.weather.WeatherAppFragment

class SearchFragment : BaseFragment() {

    private lateinit var binding: FragmentSearchBinding
    private var position = 0
    private var response: List<ConsolidatedResponse> = mutableListOf()
    private var parentResponse: List<ParentResponse> = mutableListOf()
    private lateinit var adapter: SearchAdapter

    private val viewModel: SearchVMContact by lazy {
        SearchViewModel()
    }

    override fun onBindViewModel() {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
    }

    private fun initView() {
        response = getData()
        adapter = SearchAdapter(parentResponse, response[0])
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
            initSearchView()
        }
    }

    private fun initListener() {
        adapter.onClickItemListener = {
            position = it
            addChildFragment(
                R.id.flContainerMain,
                WeatherAppFragment.newInstance(position),
                WeatherAppFragment::class.simpleName
            )
        }
        adapter.onClickAddListener = {
            initSearchView()
        }
    }

    private fun initSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val query = binding.searchView.query.toString()
                parentResponse[0].title = query
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
    }
}
