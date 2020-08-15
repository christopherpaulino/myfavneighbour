package com.chrisp.myfavneighbour.ui.charactersDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.chrisp.myfavneighbour.R
import com.chrisp.myfavneighbour.models.Character
import com.chrisp.myfavneighbour.ui.charactersDetails.profile.ProfileFragment


class DetailCharacterActivity : AppCompatActivity(),DetailCharacterContract.View {

    var idCharacter:Int = 0
    lateinit var mListener:DetailCharacterContract.Listener
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_character)
        mListener = DetailCharacterPresenter(this)
        initValues()
        idCharacter = intent.getIntExtra("id",0)
        mListener.getCharacter(idCharacter)
    }

    fun initValues(){
        progressBar = findViewById<ProgressBar>(R.id.pbar_profile)
    }

    private fun showFragment(fragment: Fragment){
        val manager =  supportFragmentManager
        val transition = manager.beginTransaction()
        transition.replace(R.id.container_character,fragment)
        transition.commit()
    }

    override fun showLoading(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
        progressBar.isIndeterminate = show
    }

    override fun setCharacter(character: Character) {
        showFragment(ProfileFragment.newInstance(character))
    }
}