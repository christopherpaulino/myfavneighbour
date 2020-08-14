package com.chrisp.myfavneighbour.ui.charactersList

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.chrisp.myfavneighbour.MainActivity
import com.chrisp.myfavneighbour.R
import com.chrisp.myfavneighbour.models.Character

class CharactersListFragment : Fragment(),CharacterListContract.View {
    lateinit internal var callback: FragmentListener
    lateinit var mListener: CharacterListContract.Listener
    lateinit var rvCharacters: RecyclerView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mListener = CharacterListPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val v = inflater.inflate(R.layout.fragment_characters_list,container,false)
        initValues(v)
        return v
    }

    override fun onStart() {
        super.onStart()
        mListener.getCharactersList()
    }

    fun initValues(view: View){
        rvCharacters = view.findViewById(R.id.list)
        progressBar = view.findViewById(R.id.pbar_list)
    }

    override fun showLoading(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
        progressBar.isIndeterminate = show
    }

    override fun goProfile(id: Int) {
        callback.goToCharacter(id)
    }

    override fun setCharactersList(characters: List<Character>) {
       rvCharacters.adapter = CharactersListAdapter(characters,this)
    }

    fun setFragmentListener(callback: FragmentListener){
        this.callback = callback
    }

    interface FragmentListener{
        fun goToCharacter(id:Int)
    }

}