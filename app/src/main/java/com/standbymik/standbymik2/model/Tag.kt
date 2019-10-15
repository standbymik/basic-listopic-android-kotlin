package com.standbymik.standbymik2.model

import com.google.gson.annotations.SerializedName

data class Tag (
    @SerializedName("name") val name:String,
    @SerializedName("slug") val slug:String
)