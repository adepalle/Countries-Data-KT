package com.example.android.countriesdata.navigator

import androidx.fragment.app.FragmentManager
import com.example.android.countriesdata.R
import com.example.android.countriesdata.navigator.activity.MainActivityNavigatorListener
import com.example.android.countriesdata.navigator.fragment.CountriesFragmentNavigatorListener
import com.example.android.countriesdata.ui.CountriesFragment
import com.example.android.countriesdata.ui.DetailFragment
import javax.inject.Inject

class MainNavigator @Inject constructor(
    private var fragmentManager: FragmentManager
) : MainActivityNavigatorListener, CountriesFragmentNavigatorListener {
    override fun displayCountriesFragment() {
        fragmentManager.beginTransaction().replace(
            R.id.activity_main_frame_layout,
            CountriesFragment.newInstance(),
            CountriesFragment.TAG
        ).commit()
    }

    override fun showDetail(countryName: String) {
        fragmentManager.beginTransaction()
            .replace(
                R.id.activity_main_frame_layout,
                DetailFragment.newInstance(countryName),
                DetailFragment.TAG
            )
            .addToBackStack(DetailFragment.TAG)
            .commit()
    }
}