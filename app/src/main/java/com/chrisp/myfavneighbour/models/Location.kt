package com.chrisp.myfavneighbour.models

import com.google.gson.annotations.SerializedName

data class Location (
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
