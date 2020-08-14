package com.chrisp.myfavneighbour.ui.charactersList

import com.chrisp.myfavneighbour.models.Character

class CharacterListContract {

    interface View{
        fun setCharactersList(characters: List<Character>)
        fun showLoading(show:Boolean)
        fun goProfile(id:Int)
    }

    interface Listener{

        fun getCharactersList()
    }



}