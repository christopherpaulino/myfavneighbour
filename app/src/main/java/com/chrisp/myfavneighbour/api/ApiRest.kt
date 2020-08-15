package com.chrisp.myfavneighbour.api

import android.content.Context
import android.content.DialogInterface
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.ConnectionPool
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiRest {
    const val BASE_URL = "https://rickandmortyapi.com/api/"

    fun create(context: Context): ApiServices? {

        if (NetworkUtil().isOnline(context)){
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        val okBuilder = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(loggingInterceptor)
        val client = okBuilder.build()

           val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            Log.d("getClient", retrofit.toString())


        return retrofit.create(ApiServices::class.java)
        }
        else{
            context.let {
                AlertDialog.Builder(it)
                    .setTitle("No Internet Connection")
                    .setPositiveButton("Retry"){ dialogInterface: DialogInterface, i: Int -> create(context)}
                    .create().show()
            }
            return null
        }

    }

}