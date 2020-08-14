package com.chrisp.myfavneighbour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.chrisp.myfavneighbour.ui.charactersList.CharactersFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        showFragment(CharactersFragment())

    }

    private fun showFragment(fragment: Fragment){
        val manager =  supportFragmentManager
        val transition = manager.beginTransaction()
        transition.replace(R.id.container,fragment)
        transition.commit()
    }
}