package com.example.myapplication.ui.base.quantitative

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentViewItemBinding
import com.example.myapplication.ui.base.BaseFragment


class QuantitativeFragment : BaseFragment() {

    companion object {
        private const val SPAN_COUNT = 2
    }

    private lateinit var binding: FragmentViewItemBinding
    private val adapter: QuantitativeAdapter by lazy {
        QuantitativeAdapter(viewModel.getQuantitativeItems())
    }

    private val viewModel: QuantitativeVMContact by lazy {
        QuantitativeViewModel()
    }

    override fun onBindViewModel() {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerView.layoutManager =
                GridLayoutManager(context, SPAN_COUNT, RecyclerView.VERTICAL, false)
            recyclerView.adapter = adapter
            recyclerView.setHasFixedSize(true)
            adapter.onClickListenItem = {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
                startActivity(browserIntent)
            }
        }
    }
}