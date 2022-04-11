package com.example.myapplication.ui.base.temple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.ui.base.BaseFragment
import com.example.myapplication.ui.base.addChildFragment
import com.example.myapplication.databinding.FragmentTempaleBinding
import com.example.myapplication.ui.base.quantitative.QuantitativeFragment

class TempleFragment : BaseFragment() {

    private lateinit var binding: FragmentTempaleBinding

    private val adapter: TempleAdapter by lazy {
        TempleAdapter(viewModel.getDayItems())
    }
    private val viewModel: TempleVMContract by lazy {
        TempleViewModel()
    }

    override fun onBindViewModel() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTempaleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        addChildFragment(
            R.id.flViewItem,
            QuantitativeFragment(),
            QuantitativeFragment::class.simpleName
        )
    }

    private fun initView() {
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        }
    }
}