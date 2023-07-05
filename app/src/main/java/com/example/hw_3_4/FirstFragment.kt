package com.example.hw_3_4

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment() {
    private lateinit var continentList: List<String>
    private lateinit var listener: OnContinentClickListener

    interface OnContinentClickListener {
        fun onContinentClick(continent: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as OnContinentClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnContinentClickListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val continentRecyclerView: RecyclerView = view.findViewById(R.id.continentRecyclerView)
        val adapter = ContinentAdapter(continentList, listener)
        continentRecyclerView.adapter = adapter
        return view
    }

    inner class ContinentAdapter(private val continents: List<String>, private val listener: OnContinentClickListener) :
        RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder>() {

        inner class ContinentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
            private val continentTextView: TextView = itemView.findViewById(R.id.continentTextView)

            init {
                itemView.setOnClickListener(this)
            }

            fun bind(continent: String) {
                continentTextView.text = continent
            }

            override fun onClick(v: View?) {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onContinentClick(continents[position])
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinentViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_continent, parent, false)
            return ContinentViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ContinentViewHolder, position: Int) {
            holder.bind(continents[position])
        }

        override fun getItemCount() = continents.size
    }
}