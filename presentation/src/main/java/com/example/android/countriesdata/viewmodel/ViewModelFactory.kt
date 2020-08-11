package com.example.android.countriesdata.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.domain.usecase.RetrieveAllCountries
import com.example.android.domain.usecase.RetrieveCountryByName
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private var retrieveAllCountries: RetrieveAllCountries,
    private var retrieveCountryByName: RetrieveCountryByName
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(CountriesViewModel::class.java) -> {
            CountriesViewModel(retrieveAllCountries) as T
        }
        modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
            DetailViewModel(retrieveCountryByName) as T
        }
        else -> throw IllegalArgumentException("unknown model class $modelClass")
    }
}