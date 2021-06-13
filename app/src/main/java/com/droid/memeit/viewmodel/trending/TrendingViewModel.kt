package com.droid.memeit.viewmodel.trending

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droid.memeit.main.MainRepository
import com.droid.memeit.model.Meme
import com.droid.memeit.model.MemeResponseItem
import com.droid.memeit.utils.DispatcherProvider
import com.droid.memeit.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Created by SARATH on 11-06-2021
 */
class TrendingViewModel @ViewModelInject constructor(
    private val repository : MainRepository,
    private val dispatchers : DispatcherProvider
) : ViewModel() {

    sealed class MemeEvent {
        class Success(val result: List<Meme>) : MemeEvent()
        class Failure(val error: String) : MemeEvent()
        object Loading : MemeEvent()
        object Empty : MemeEvent()
    }

    private val _memes = MutableStateFlow<MemeEvent>(MemeEvent.Empty)
    val memes: StateFlow<MemeEvent> = _memes


    fun getTrendingMemes(){
            viewModelScope.launch(dispatchers.io) {
                _memes.value = MemeEvent.Loading
                when(val memeResponse = repository.getLatestMemes()){
                    is Resource.Error -> {
                            _memes.value =MemeEvent.Failure(memeResponse.message!!)
                    }
                    is Resource.Success -> {
                            val data = memeResponse.data
                        if (data == null){
                            _memes.value = MemeEvent.Failure("UnExpected Error")
                        }else{
                            _memes.value = MemeEvent.Success(data.memes)
                        }
                    }
                }
            }
        }
}