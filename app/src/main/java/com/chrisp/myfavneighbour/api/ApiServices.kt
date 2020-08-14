package com.chrisp.myfavneighbour.api

import com.chrisp.myfavneighbour.models.CharacterListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("character")
    fun getCharactersList(@Query("page")page: Int = 1) : Call<CharacterListResponse>

    @GET("character/{id}")
    fun getCharacterById()
}