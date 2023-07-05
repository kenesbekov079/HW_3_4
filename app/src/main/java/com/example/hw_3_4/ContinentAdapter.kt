package com.example.hw_3_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface OnContinentClickListener {
    fun onContinentClick(continent: String)
}

class ContinentAdapter(private val continents: Array<String>, private val listener: OnContinentClickListener) : RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_continent, parent, false)
        return ContinentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContinentViewHolder, position: Int) {
        val continent = continents[position]
        holder.bind(continent, listener)
    }

    override fun getItemCount() = continents.size

    class ContinentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val continentTextView: TextView = itemView.findViewById(R.id.continentTextView)

        fun bind(continent: String, listener: OnContinentClickListener) {
            continentTextView.text = continent
            itemView.setOnClickListener { listener.onContinentClick(continent) }
        }
    }
}