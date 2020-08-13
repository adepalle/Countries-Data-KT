package com.example.android.countriesdata.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_bar_spinner, menu)
        val menuItem = menu.findItem(R.id.action_bar_spinner_item)
        val spinner = menuItem.actionView as Spinner
        val regions = resources.getStringArray(R.array.Regions)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, regions)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                countriesAdapter.filter(regions[position])
            }
        }
    }

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