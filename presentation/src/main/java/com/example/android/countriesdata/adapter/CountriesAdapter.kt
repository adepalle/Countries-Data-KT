package com.example.android.countriesdata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.countriesdata.R
import com.example.android.countriesdata.wrapper.CountryViewDataWrapper
import javax.inject.Inject

class CountriesAdapter @Inject constructor() : RecyclerView.Adapter<CountriesViewHolder>() {
    var onItemClickListener: (String) -> Unit = {}
    private val countries: MutableList<CountryViewDataWrapper> = mutableListOf()
    private val filteredCountries: MutableList<CountryViewDataWrapper> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder =
        CountriesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        )

    override fun getItemCount(): Int = filteredCountries.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bindData(filteredCountries[position], onItemClickListener)
    }

    fun setCountries(newCountries: List<CountryViewDataWrapper>) {
        countries.clear()
        countries.addAll(newCountries)
        filteredCountries.addAll(newCountries)
        notifyDataSetChanged()
    }

    fun filter(regionName: String) {
        filteredCountries.clear()
        if (regionName == "All") {
            filteredCountries.addAll(countries)
        } else {
            filteredCountries.addAll(countries.filter { a -> a.getCountryRegion().contains(regionName) })
        }
        notifyDataSetChanged()
    }
}