package com.droid.memeit.viewmodel.saved

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.droid.memeit.main.MainRepository
import com.droid.memeit.utils.DispatcherProvider

/**
 * Created by SARATH on 12-06-2021
 */
class SavedViewModel @ViewModelInject constructor(
    private val repository : MainRepository,
    private val dispatchers : DispatcherProvider
) : ViewModel(){

}