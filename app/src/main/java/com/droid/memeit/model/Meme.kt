package com.droid.memeit.model

import com.google.gson.annotations.SerializedName

data class Meme(
    @SerializedName("author")
    val author: String,
    @SerializedName("nsfw")
    val nsfw: Boolean,
    @SerializedName("postLink")
    val postLink: String,
    @SerializedName("preview")
    val preview: List<String>,
    @SerializedName("spoiler")
    val spoiler: Boolean,
    @SerializedName("subreddit")
    val subreddit: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("ups")
    val ups: Int,
    @SerializedName("url")
    val url: String
)