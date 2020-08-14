package com.chrisp.myfavneighbour.models

import com.google.gson.annotations.SerializedName

data class Character (
    @SerializedName("")
    val id: Int,
    @SerializedName("")
    val name: String,
    @SerializedName("")
    val status: Status,
    @SerializedName("")
    val species: String,
    @SerializedName("")
    val type: String,
    @SerializedName("")
    val gender: Gender,
    @SerializedName("")
    val origin: Location,
    @SerializedName("")
    val location: Location,
    @SerializedName("")
    val image: String,
    @SerializedName("")
    val episode: List<String>,
    @SerializedName("")
    val url: String,
    @SerializedName("")
    val created: String
){
    override fun toString(): String {
        return super.toString()
    }
}

