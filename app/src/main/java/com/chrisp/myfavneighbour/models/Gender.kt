package com.chrisp.myfavneighbour.models

import com.google.gson.annotations.SerializedName

data class Gender(@SerializedName("gender") val gender: GenderList)

enum class GenderList(val value: String) {
    Female("Female"),
    Male("Male"),
    Unknown("unknown"),
    Genderless("Genderless");

}