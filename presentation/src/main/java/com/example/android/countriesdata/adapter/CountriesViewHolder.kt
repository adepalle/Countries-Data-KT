package com.example.android.countriesdata.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.countriesdata.wrapper.CountryViewDataWrapper
import kotlinx.android.synthetic.main.item_country.view.item_country_flag
import kotlinx.android.synthetic.main.item_country.view.item_country_name
import kotlinx.android.synthetic.main.item_country.view.item_country_native_name

class CountriesViewHolder(private val containerView: View) :
    RecyclerView.ViewHolder(containerView) {
    fun bindData(
        countryViewDataWrapper: CountryViewDataWrapper,
        onItemClickListener: (String) -> Unit
    ) {
        with(containerView) {
            item_country_name.text = countryViewDataWrapper.getCountryName()
            item_country_native_name.text = countryViewDataWrapper.getCountryNativeName()
            Glide.with(item_country_flag)
                .load(countryViewDataWrapper.getCountryFlagUrl())
                .placeholder(ColorDrawable(Color.BLACK))
                .fallback(ColorDrawable(Color.GREEN))
                .error(ColorDrawable(Color.RED))
                .into(item_country_flag)
            setOnClickListener { onItemClickListener(countryViewDataWrapper.getCountryName()) }
        }
    }
}