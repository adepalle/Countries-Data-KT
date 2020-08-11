package com.example.android.data.manager.api

import com.example.android.data.entity.remote.CountryRemoteEntity
import com.example.android.data.manager.api.service.CountryServiceApi
import io.reactivex.Single
import javax.inject.Inject

class ApiManagerImpl @Inject constructor(
    private var countryServiceApi: CountryServiceApi
) : ApiManager {
    override fun getAllCountries(): Single<List<CountryRemoteEntity>> {
        return countryServiceApi.getAllCountries()
            .map {
                it.countryEntities
            }
    }

    override fun getCountryByName(countryName: String): Single<CountryRemoteEntity> {
        return countryServiceApi.getCountryFromName(countryName)
            .map {
                it.countryEntities.first()
            }
    }
}