package com.example.android.domain.repository

import com.example.android.domain.model.Country
import io.reactivex.Single

interface CountryRepository {
    fun loadAllCountries(): Single<List<Country>>
    fun loadCountryByName(countryName: String): Single<Country>
}