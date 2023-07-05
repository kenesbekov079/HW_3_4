package com.example.hw_3_4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class SecondFragment : Fragment() {
    private lateinit var countryList: List<String>
    private lateinit var countryRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        countryRecyclerView = view.findViewById(R.id.countryRecyclerView)
        populateCountries()
        return view
    }

    private fun populateCountries() {
        val adapter = CountryAdapter(countryList)
        countryRecyclerView.adapter = adapter
    }

    inner class CountryAdapter(private val countries: List<String>) :
        RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

        inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val countryTextView: TextView = itemView.findViewById(R.id.countryTextView)

            fun bind(country: String) {
                countryTextView.text = country
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
            return CountryViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
            holder.bind(countries[position])
        }

        override fun getItemCount() = countries.size
    }
}