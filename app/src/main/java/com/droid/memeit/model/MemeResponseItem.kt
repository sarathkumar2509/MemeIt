package com.droid.memeit.model

import com.droid.memeit.model.Meme
import com.google.gson.annotations.SerializedName

data class MemeResponseItem(
    @SerializedName("count")
    val count: Int,
    @SerializedName("memes")
    val memes: List<Meme>
)