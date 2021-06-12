package com.droid.memeit.viewmodel.trending

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droid.memeit.main.MainRepository
import com.droid.memeit.utils.DispatcherProvider
import kotlinx.coroutines.launch

/**
 * Created by SARATH on 11-06-2021
 */
class TrendingViewModel @ViewModelInject constructor(
    private val repository : MainRepository,
    private val dispatchers : DispatcherProvider
) : ViewModel() {

        fun getLatestMemes(){
            viewModelScope.launch(dispatchers.io) {
                    val memesResponse = repository.getLatestMemes()
            }
        }
}