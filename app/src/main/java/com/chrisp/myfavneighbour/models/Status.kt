package com.chrisp.myfavneighbour.models

import com.google.gson.annotations.SerializedName

data class Status(@SerializedName("gender") val gender: GenderList)

enum class StatusList(val value: String) {
    Alive("Alive"),
    Dead("Dead"),
    Unknown("unknown");
}