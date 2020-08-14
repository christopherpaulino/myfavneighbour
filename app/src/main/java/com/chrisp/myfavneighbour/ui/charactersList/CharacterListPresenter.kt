package com.chrisp.myfavneighbour.ui.charactersList

import android.content.Context
import android.util.Log
import com.chrisp.myfavneighbour.api.ApiRest
import com.chrisp.myfavneighbour.models.CharacterListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterListPresenter (val mView:CharacterListContract.View):CharacterListContract.Listener{

    override fun getCharactersList() {
        mView.showLoading(true)
        ApiRest.create().getCharactersList().enqueue(object :Callback<CharacterListResponse>{

            override fun onResponse( call: Call<CharacterListResponse>,response: Response<CharacterListResponse>) {
                if (response.isSuccessful){
                    mView.showLoading(false)
                    mView.setCharactersList(response.body()!!.result)
                }


            }

            override fun onFailure(call: Call<CharacterListResponse>, t: Throwable) {
                Log.e("Retrofit",t.message!!)
               // mView.showLoading(false)
            }


        })
    }
}