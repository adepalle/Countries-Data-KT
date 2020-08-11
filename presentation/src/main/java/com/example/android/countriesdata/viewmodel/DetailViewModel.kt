package com.example.android.countriesdata.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.countriesdata.wrapper.CountryViewDataWrapper
import com.example.android.domain.usecase.RetrieveCountryByName
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val retrieveCountryByName: RetrieveCountryByName
) : ViewModel(){
    var country = MutableLiveData<CountryViewDataWrapper>()

    fun loadCountryDetail(countryName: String){
        retrieveCountryByName.subscribe(
            onSuccess = {
                country.postValue(CountryViewDataWrapper(it))
            },
            onError = {
                Log.e(DetailViewModel::class.toString(), "Error on load detail", it)
            },
            params = RetrieveCountryByName.Params(countryName)
        )
    }
}