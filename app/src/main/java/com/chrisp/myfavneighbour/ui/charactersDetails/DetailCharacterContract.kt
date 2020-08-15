package com.chrisp.myfavneighbour.ui.charactersDetails

import com.chrisp.myfavneighbour.models.Character

class DetailCharacterContract {

    interface View{
        fun showLoading(show:Boolean)
        fun setCharacter(character:List<Character>)
    }

    interface Listener{
        fun getCharacter(query:String)
    }
}