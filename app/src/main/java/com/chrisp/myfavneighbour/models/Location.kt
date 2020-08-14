package com.chrisp.myfavneighbour.models

import com.google.gson.annotations.SerializedName

data class Location (
    @SerializedName("name")
    val name: String,
    @SerializedName("name")
    val url: String
)
