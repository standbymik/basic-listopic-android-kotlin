package com.standbymik.standbymik2.model

import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("avatar") val avatar: Avatar,
    @SerializedName("slug") val slug: String
) {

}