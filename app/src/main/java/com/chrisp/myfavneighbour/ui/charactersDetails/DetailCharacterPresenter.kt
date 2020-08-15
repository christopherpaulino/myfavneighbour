package com.chrisp.myfavneighbour.ui.charactersDetails

import android.content.Context
import android.util.Log
import androidx.annotation.Nullable
import com.chrisp.myfavneighbour.api.ApiRest
import com.chrisp.myfavneighbour.models.Character
import com.chrisp.myfavneighbour.models.CharacterListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailCharacterPresenter(val mView: DetailCharacterContract.View,val mCtx: Context):DetailCharacterContract.Listener {


    override fun getCharacter(query:String) {
        mView.showLoading(true)
        val rest  =ApiRest.create(mCtx)
        if (rest!=null)rest.getCharacterById(query).enqueue(object :Callback<List<Character>>{

            override fun onResponse( call: Call<List<Character>>,response: Response<List<Character>>) {
                if (response.isSuccessful){
                    mView.showLoading(false)
                    mView.setCharacter(response.body()!!)
                }

            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                Log.e("Retrofit",t.message!!)
                // mView.showLoading(false)
            }


        })else mView.showLoading(false)

    }
    }
