package com.droid.memeit.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.droid.memeit.R
import com.droid.memeit.adapter.TrendingMemeAdapter
import com.droid.memeit.databinding.FragmentTrendingMemeBinding
import com.droid.memeit.viewmodel.trending.TrendingViewModel
import kotlinx.coroutines.flow.collect
import java.lang.Exception

/**
 * Created by SARATH on 12-06-2021
 */
class TrendingFragment : Fragment(R.layout.fragment_trending_meme) {

    private lateinit var binding : FragmentTrendingMemeBinding
    private lateinit var viewModel: TrendingViewModel
    private lateinit var trendingMemeAdapter: TrendingMemeAdapter
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProvider(this)[TrendingViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTrendingMemeBinding.bind(view)

        sharedPreferences = activity?.getSharedPreferences("data" , Context.MODE_PRIVATE) ?: throw Exception("Invalid Activity")
        val editor = sharedPreferences.edit()


        if (loadSharedPreference()){
            viewModel.getTrendingMemes()
        }else{
            Log.d("TRENDINGFRAGMENT","${loadSharedPreference()}")
        }

        setupRecyclerView()


        lifecycleScope.launchWhenCreated {
            viewModel.memes.collect { event ->
                when(event){
                    is TrendingViewModel.MemeEvent.Success -> {
                        binding.pbLoading.isVisible = false
                        trendingMemeAdapter.trendingMemeResponse = event.result.toMutableList()
                        editor.apply{
                            putString("data", 1.toString())
                            apply()
                        }
                    }
                    is TrendingViewModel.MemeEvent.Failure -> {
                        binding.pbLoading.isVisible = true
                    }
                    is TrendingViewModel.MemeEvent.Loading -> {
                        binding.pbLoading.isVisible = true
                    }
                    else -> Unit
                }

            }
        }
    }

    private fun loadSharedPreference() : Boolean{
        val data = sharedPreferences.getString("data",null)
        return data == null
    }

    private fun setupRecyclerView() {
        binding.rvTrendingMemes.apply {
                trendingMemeAdapter = TrendingMemeAdapter(context)
                adapter = trendingMemeAdapter
//                trendingMemeAdapter.notifyDataSetChanged()
                layoutManager = GridLayoutManager(activity,2)
        }
    }

}