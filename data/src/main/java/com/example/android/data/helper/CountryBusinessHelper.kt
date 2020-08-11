package com.example.android.data.helper

import com.example.android.data.entity.CountryEntity
import com.example.android.data.manager.api.ApiManager
import com.example.android.data.mapper.remote.CountryRemoteEntityDataMapper
import io.reactivex.Single
import javax.inject.Inject

class CountryBusinessHelper @Inject constructor(
    private val apiManager: ApiManager,
    private val countryRemoteEntityDataMapper: CountryRemoteEntityDataMapper
) {
    fun getAllCountries(): Single<List<CountryEntity>> {
        return apiManager.getAllCountries()
            .map {
                countryRemoteEntityDataMapper.transformRemoteEntityList(it)
                //TODO Save into local db
            }
            .onErrorReturn {
                mutableListOf()
                //TODO Try to get local item to fill list
            }
            .doOnSuccess {
                //TODO update cache
            }
    }

    fun getCountryByName(name: String): Single<CountryEntity> {
        return apiManager.getCountryByName(name)
            .map {
                countryRemoteEntityDataMapper.transformRemoteEntity(it)
            }.onErrorReturn {
                null
            }
    }
}