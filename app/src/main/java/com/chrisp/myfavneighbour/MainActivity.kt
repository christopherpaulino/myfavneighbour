package com.chrisp.myfavneighbour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.chrisp.myfavneighbour.ui.charactersDetails.CharacterActivity
import com.chrisp.myfavneighbour.ui.charactersList.CharactersListFragment

class MainActivity : AppCompatActivity(),CharactersListFragment.FragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        showFragment(CharactersListFragment())

    }

    private fun showFragment(fragment: Fragment){
        val manager =  supportFragmentManager
        val transition = manager.beginTransaction()
        transition.replace(R.id.container,fragment)
        transition.commit()
    }

    override fun onAttachFragment(fragment: Fragment) {
        if (fragment is CharactersListFragment){
            fragment.setFragmentListener(this)
        }
    }


    override fun goToCharacter(id: Int) {
        val intent = Intent()
        intent.putExtra("id",id)
        intent.setClass(this,CharacterActivity::class.java)
        startActivity(intent)
    }
}