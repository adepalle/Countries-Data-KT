package com.example.android.data.repository

import com.example.android.data.helper.CountryBusinessHelper
import com.example.android.data.mapper.CountryEntityDataMapper
import com.example.android.domain.model.Country
import com.example.android.domain.repository.CountryRepository
import io.reactivex.Single
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private var countryBusinessHelper: CountryBusinessHelper,
    private var countryEntityDataMapper: CountryEntityDataMapper
) : CountryRepository {
    override fun loadAllCountries(): Single<List<Country>> = Single.defer {
        countryBusinessHelper.getAllCountries()
            .map {
                countryEntityDataMapper.transformEntityList(it)
            }
    }

    override fun loadCountryByName(countryName: String): Single<Country> = Single.defer {
        countryBusinessHelper.getCountryByName(countryName)
            .map {
                countryEntityDataMapper.transformEntity(it)
            }
    }

}