package com.chrisp.myfavneighbour.models

import com.google.gson.annotations.SerializedName


data class InfoCharacterList (
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Long,
    @SerializedName("next")
    val next: String,
    @SerializedName("prev")
    val prev: String
)
