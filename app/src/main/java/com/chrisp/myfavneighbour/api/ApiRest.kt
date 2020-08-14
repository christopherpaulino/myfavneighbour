package com.chrisp.myfavneighbour.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiRest {
    const val BASE_URL = "https://rickandmortyapi.com/api/"

    fun create(): ApiServices {


        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val httpLogger: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
            level = HttpLoggingInterceptor.Level.BASIC
        }


        val okHttpCLient: OkHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(httpLogger)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpCLient)
            .build()

        return retrofit.create(ApiServices::class.java)

    }

}