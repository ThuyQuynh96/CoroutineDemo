package com.example.myapplication.ui.base.weather

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.ui.base.BaseFragment
import com.example.myapplication.ui.base.addChildFragment
import com.example.myapplication.data.response.ConsolidatedResponse
import com.example.myapplication.databinding.FragmentWeatherAppBinding
import com.example.myapplication.ui.base.temple.TempleFragment
import java.text.SimpleDateFormat
import java.util.*

class WeatherAppFragment : BaseFragment() {

    companion object {
        private const val POSITION = "position"
        fun newInstance(position: Int): WeatherAppFragment {
            return WeatherAppFragment().apply {
                arguments = Bundle().apply {
                    putInt(POSITION, position)
                }
            }
        }
    }

    private lateinit var binding: FragmentWeatherAppBinding
    private var todayResponse: List<ConsolidatedResponse> = mutableListOf()

    override fun onBindViewModel() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherAppBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addChildFragment(R.id.flSumDay, TempleFragment(), TempleFragment::class.simpleName)
        Handler(Looper.getMainLooper()).postDelayed({
            getData().apply {
                todayResponse = this
            }
            initView()
        }, 2000L)
    }

    private fun initView() {
        binding.apply {
            if (todayResponse.isNotEmpty()) {
                todayResponse[0].let {
                    d("XXX", "fg : $it")
                    tvTemplate.text = ((it.min_temp.toInt() + it.max_temp.toInt()) / 2).toString()
                    tvWeath.text = it.weather_state_name
                }
            }
            tvCity.text = "Lon Don"
            val date = Date()
            tvDay.text = SimpleDateFormat("EEEE").format(date.time)
        }
    }
}
