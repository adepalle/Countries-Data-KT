package com.example.android.data.manager.api

import com.example.android.data.entity.remote.CountryRemoteEntity
import io.reactivex.Single

interface ApiManager {
    fun getAllCountries(): Single<List<CountryRemoteEntity>>
    fun getCountryByName(countryName: String): Single<CountryRemoteEntity>
}