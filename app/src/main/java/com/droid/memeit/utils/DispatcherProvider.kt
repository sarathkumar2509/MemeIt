package com.droid.memeit.utils

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by SARATH on 11-06-2021
 */
interface DispatcherProvider {
    val main : CoroutineDispatcher
    val io : CoroutineDispatcher
    val default : CoroutineDispatcher
    val unconfined : CoroutineDispatcher
}