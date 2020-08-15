package com.chrisp.myfavneighbour.ui.charactersDetails

import android.util.Log
import com.chrisp.myfavneighbour.api.ApiRest
import com.chrisp.myfavneighbour.models.Character
import com.chrisp.myfavneighbour.models.CharacterListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailCharacterPresenter(val mView: DetailCharacterContract.View):DetailCharacterContract.Listener {


    override fun getCharacter(id: Int) {
        mView.showLoading(true)
        ApiRest.create().getCharacterById(id).enqueue(object :Callback<Character>{

            override fun onResponse( call: Call<Character>,response: Response<Character>) {
                if (response.isSuccessful){
                    mView.showLoading(false)
                    mView.setCharacter(response.body()!!)
                }


            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.e("Retrofit",t.message!!)
                // mView.showLoading(false)
            }


        })
    }
    }
