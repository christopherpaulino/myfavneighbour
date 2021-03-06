package com.chrisp.myfavneighbour.ui.charactersDetails.profile

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.chrisp.myfavneighbour.R
import com.chrisp.myfavneighbour.databinding.FragmentProfileBinding
import com.chrisp.myfavneighbour.models.Character
import com.chrisp.myfavneighbour.ui.charactersDetails.DetailCharacterActivity

const val ARG_CHARACTER ="character"
class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    lateinit var character :Character
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        character = arguments?.getSerializable(ARG_CHARACTER) as Character


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile, container, false)
        binding.character = character
        loadPhoto(character.image,binding.ivProfile,binding.loadingImg)
        loadPhoto(character.neighbour_image,binding.ivNeighbour,binding.loadingImgNeighbourd)

        binding.findBtn.setOnClickListener {
            (activity as DetailCharacterActivity).getCharacters()
        }

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        binding.character
    }

    private fun loadPhoto(url: String,view: ImageView,loading: ProgressBar){
        loading.visibility = View.VISIBLE
        Glide.with(requireContext())
            .load(url)
            .placeholder(R.drawable.ic_person)
            .error(R.drawable.ic_person)
            .addListener(object :RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    loading.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    loading.visibility = View.GONE
                    return false
                }
            })
            .into(view);
    }

    companion object {
        fun newInstance(character: Character): ProfileFragment {
            val fragment: ProfileFragment? = ProfileFragment()
            val bundle:Bundle?= Bundle()
            bundle!!.putSerializable(ARG_CHARACTER,character)
            fragment!!.arguments = bundle
            return fragment
        }
    }



}