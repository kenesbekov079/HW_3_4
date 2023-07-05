package com.example.hw_3_4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CountryAdapter
    private var countries = mutableListOf<String>()

    companion object {
        private const val CONTINENT_KEY = "continent_key"

        fun newInstance(continent: String): CountryFragment {
            val args = Bundle()
            args.putString(CONTINENT_KEY, continent)
            val fragment = CountryFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val continent = arguments?.getString(CONTINENT_KEY)
        // Здесь должна быть логика, возвращающая список стран по выбранному континенту
        // Пример: countries = getCountryListByContinent(continent)

        recyclerView = view.findViewById(R.id.countryRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = CountryAdapter(countries)
        recyclerView.adapter = adapter

        return view
    }
}