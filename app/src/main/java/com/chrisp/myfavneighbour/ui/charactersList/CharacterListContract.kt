package com.chrisp.myfavneighbour.ui.charactersList

import com.chrisp.myfavneighbour.models.Character
import com.chrisp.myfavneighbour.models.CharacterListResponse

class CharacterListContract {

    interface View{
        fun setCharactersList(characters: CharacterListResponse)
        fun showLoading(show:Boolean)
        fun goProfile(id:Int,total:Int)
    }

    interface Listener{

        fun getCharactersList()
    }



}