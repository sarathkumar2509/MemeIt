package com.droid.memeit.main

import android.util.Log
import com.droid.memeit.model.MemeResponseItem
import com.droid.memeit.model.api.MemeApi
import com.droid.memeit.utils.Resource
import javax.inject.Inject

/**
 * Created by SARATH on 11-06-2021
 */
class DefaultRepository @Inject constructor(
    private val api : MemeApi
) : MainRepository {

    override suspend fun getLatestMemes(): Resource<MemeResponseItem> {
        return try {
            val response = api.getLatestMemes()
            val result =response.body()

            if (response.isSuccessful && result != null ){
                Log.d("DefaultRepository1","$result")
                Resource.Success(result)
            }else{
                Log.d("DefaultRepository2","${response.message()}")
                Resource.Error(response.message())
            }
        }catch (e : Exception){
            Log.d("DefaultRepository3","${e.message}")
            Resource.Error(e.message ?: "An Error Occurred")
        }
    }
}