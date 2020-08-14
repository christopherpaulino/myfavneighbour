package com.chrisp.myfavneighbour.api

import com.chrisp.myfavneighbour.models.CharacterListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("character")
    fun getCharactersList(@Query("page")page: Int) : Call<CharacterListResponse>
}