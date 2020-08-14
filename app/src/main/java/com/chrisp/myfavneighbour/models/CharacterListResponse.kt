package com.chrisp.myfavneighbour.models

import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    @SerializedName("info")
    val info: InfoCharacterList,
    @SerializedName("results")
    val result: List<Character>,
    @SerializedName("message")
    val error: String
)