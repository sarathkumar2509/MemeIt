package com.droid.memeit.utils

/**
 * Created by SARATH on 11-06-2021
 */
sealed class Resource<T>(val data : T? , val message : String?) {
    class Success<T>(data: T?) :Resource<T>(data,null)
    class Error<T>(message : String) :Resource<T>(null, message)
}