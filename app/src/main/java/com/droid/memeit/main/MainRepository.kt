package com.droid.memeit.main

import com.droid.memeit.model.MemeResponseItem
import com.droid.memeit.utils.Resource

/**
 * Created by SARATH on 11-06-2021
 */
interface MainRepository {

    suspend fun getLatestMemes() : Resource<MemeResponseItem>
}