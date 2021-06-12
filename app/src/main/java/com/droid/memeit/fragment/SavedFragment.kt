package com.droid.memeit.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.droid.memeit.R
import com.droid.memeit.databinding.FragmentSavedMemeBinding
import com.droid.memeit.viewmodel.saved.SavedViewModel
import java.lang.Exception

/**
 * Created by SARATH on 12-06-2021
 */
class SavedFragment : Fragment(R.layout.fragment_saved_meme) {

    private lateinit var binding : FragmentSavedMemeBinding
    private lateinit var viewModel: SavedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProvider(this)[SavedViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSavedMemeBinding.bind(view)
    }

}