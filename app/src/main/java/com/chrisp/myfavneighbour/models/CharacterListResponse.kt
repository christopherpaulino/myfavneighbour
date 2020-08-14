package com.chrisp.myfavneighbour.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    @SerializedName("info")
    @Expose
    val info: InfoCharacterList,


    @SerializedName("results")
    @Expose
    val result: List<Character>
)
{
    override fun toString(): String {
        return "info ${info}"
    }
}