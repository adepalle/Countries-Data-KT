package com.example.android.countriesdata.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.android.countriesdata.R
import com.example.android.countriesdata.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_country_detail.fragment_country_detail_alpha_code
import kotlinx.android.synthetic.main.fragment_country_detail.fragment_country_detail_area
import kotlinx.android.synthetic.main.fragment_country_detail.fragment_country_detail_currency
import kotlinx.android.synthetic.main.fragment_country_detail.fragment_country_detail_flag_thumbnail
import kotlinx.android.synthetic.main.fragment_country_detail.fragment_country_detail_lang
import kotlinx.android.synthetic.main.fragment_country_detail.fragment_country_detail_latitude
import kotlinx.android.synthetic.main.fragment_country_detail.fragment_country_detail_longitude
import kotlinx.android.synthetic.main.fragment_country_detail.fragment_country_detail_name
import kotlinx.android.synthetic.main.fragment_country_detail.fragment_country_detail_native_name
import kotlinx.android.synthetic.main.fragment_country_detail.fragment_country_detail_region_subregion

private const val COUNTRY_NAME_KEY = "COUNTRY_NAME_KEY"


class DetailFragment : BaseVMFragment<DetailViewModel>() {
    companion object {
        fun newInstance(countryName: String): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(COUNTRY_NAME_KEY, countryName)
                }
            }
        }

        const val TAG = "DetailFragment"
    }

    override val viewModelClass = DetailViewModel::class

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_country_detail, container, false)
    }

    override fun initObservers() {
        viewModel.loadCountryDetail(getArguments(arguments))
        viewModel.country.observe(viewLifecycleOwner, Observer { countryDataWrapper ->
            fragment_country_detail_name.text = countryDataWrapper.getCountryName()
            fragment_country_detail_native_name.text = countryDataWrapper.getCountryNativeName()
            fragment_country_detail_region_subregion.text = countryDataWrapper.getCountryRegion()
            fragment_country_detail_latitude.text = countryDataWrapper.getCountryLatitude()
            fragment_country_detail_longitude.text = countryDataWrapper.getCountryLongitude()
            fragment_country_detail_area.text = countryDataWrapper.getCountryArea()
            fragment_country_detail_lang.text = countryDataWrapper.getCountryNativeLanguage()
            fragment_country_detail_alpha_code.text = countryDataWrapper.getCountryAlpha2Code()
            fragment_country_detail_currency.text = countryDataWrapper.getCountryCurrency()
            Glide.with(this)
                .load(countryDataWrapper.getCountryFlagUrl())
                .placeholder(ColorDrawable(Color.BLACK))
                .fallback(ColorDrawable(Color.GREEN))
                .error(ColorDrawable(Color.RED))
                .into(fragment_country_detail_flag_thumbnail)
        })
    }

    private fun getArguments(arguments: Bundle?): String {
        return arguments?.get(COUNTRY_NAME_KEY) as String
    }
}