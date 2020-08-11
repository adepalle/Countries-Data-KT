package com.example.android.countriesdata.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.android.countriesdata.R
import com.example.android.countriesdata.adapter.CountriesAdapter
import com.example.android.countriesdata.navigator.fragment.CountriesFragmentNavigatorListener
import com.example.android.countriesdata.viewmodel.CountriesViewModel
import kotlinx.android.synthetic.main.fragment_list_countries.view.fragment_list_countries_recyclerview_countries
import javax.inject.Inject

class CountriesFragment : BaseVMFragment<CountriesViewModel>() {

    @Inject
    lateinit var countriesAdapter: CountriesAdapter

    @Inject
    lateinit var navigatorListener: CountriesFragmentNavigatorListener

    override val viewModelClass = CountriesViewModel::class

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_countries, container, false)

        countriesAdapter.onItemClickListener = {
            navigatorListener.showDetail(it)
        }
        view.fragment_list_countries_recyclerview_countries.adapter = countriesAdapter

        return view
    }

    override fun initObservers() {
        viewModel.countriesList.observe(viewLifecycleOwner, Observer {
            countriesAdapter.setCountries(it)
        })
    }

    companion object {
        fun newInstance(): CountriesFragment {
            return CountriesFragment()
        }

        const val TAG = "CountriesFragment"
    }
}