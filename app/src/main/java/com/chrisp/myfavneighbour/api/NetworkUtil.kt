package com.chrisp.myfavneighbour.api

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil {
    fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}