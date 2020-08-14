package com.chrisp.myfavneighbour.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class InfoCharacterList (
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("pages")
    @Expose
    val pages: Long,
    @SerializedName("next")
    @Expose
    val next: String,
    @SerializedName("prev")
    @Expose
    val prev: String
)
