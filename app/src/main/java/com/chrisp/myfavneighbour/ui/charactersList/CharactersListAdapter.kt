package com.chrisp.myfavneighbour.ui.charactersList

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.chrisp.myfavneighbour.R
import com.chrisp.myfavneighbour.models.Character


class CharactersListAdapter(private val values: List<Character>, private val mView:CharacterListContract.View) : RecyclerView.Adapter<CharactersListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_characters, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.name.text = item.name
        holder.gender.text = item.gender
        holder.status.text = item.status
        holder.card.setOnClickListener{
           mView.goProfile(item.id)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal val name = view.findViewById<TextView>(R.id.tv_name)
        internal val gender = view.findViewById<TextView>(R.id.tv_gender)
        internal val status = view.findViewById<TextView>(R.id.tv_status)
        internal val card = view.findViewById<CardView>(R.id.card)

    }
}