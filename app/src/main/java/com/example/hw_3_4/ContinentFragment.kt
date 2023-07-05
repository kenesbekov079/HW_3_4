package com.example.hw_3_4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContinentFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContinentAdapter
    private val continents = arrayOf("Африка", "Азия", "Европа", "Северная Америка", "Южная Америка", "Австралия")

    companion object {
        fun newInstance(): ContinentFragment {
            return ContinentFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        recyclerView = view.findViewById(R.id.continentRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = ContinentAdapter(continents, object : OnContinentClickListener {
            override fun onContinentClick(continent: String) {
                val countryFragment = CountryFragment.newInstance(continent)
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.continentTextView, countryFragment)
                    ?.addToBackStack(null)
                    ?.commit()
            }
        })
        recyclerView.adapter = adapter

        return view
    }
}
