package com.droid.memeit.model.api

import com.droid.memeit.model.MemeResponseItem
import com.droid.memeit.utils.Resource
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by SARATH on 10-06-2021
 */
interface MemeApi {

    @GET("5")
    suspend fun getLatestMemes() : Response<MemeResponseItem>
}