package com.droid.memeit.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.droid.memeit.R
import com.droid.memeit.databinding.FragmentCreateMemeBinding
import com.droid.memeit.viewmodel.trending.TrendingViewModel
import java.lang.Exception

/**
 * Created by SARATH on 12-06-2021
 */
class CreateMemeFragment : Fragment(R.layout.fragment_create_meme) {

    private lateinit var binding : FragmentCreateMemeBinding
    private lateinit var viewModel: TrendingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProvider(this)[TrendingViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateMemeBinding.bind(view)
    }

}