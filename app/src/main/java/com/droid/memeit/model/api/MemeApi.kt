package com.droid.memeit.model.api

import com.droid.memeit.model.Meme
import com.droid.memeit.model.MemeResponseItem
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by SARATH on 10-06-2021
 */
interface MemeApi {

    @GET("16")
    suspend fun getLatestMemes() : Response<MemeResponseItem>
}