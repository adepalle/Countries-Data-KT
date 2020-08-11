package com.example.android.countriesdata.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.countriesdata.wrapper.CountryViewDataWrapper
import com.example.android.domain.usecase.RetrieveAllCountries
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

private const val ERROR_MESSAGE_COUNTRIES_LOAD = "Error during countries loading in ViewModel"

class CountriesViewModel @Inject constructor(
    private val retrieveAllCountries: RetrieveAllCountries
) : ViewModel() {
    private val disposable = CompositeDisposable()
    val countriesList = MutableLiveData<List<CountryViewDataWrapper>>()

    init {
        loadCountries()
    }

    private fun loadCountries() {
        retrieveAllCountries.subscribe(
            onError = {
                Log.e(
                    CountriesViewModel::class.toString(),
                    ERROR_MESSAGE_COUNTRIES_LOAD,
                    it
                )
            },
            onSuccess = { countryList ->
                countriesList.postValue(countryList.map {
                    CountryViewDataWrapper(
                        it
                    )
                })
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}