package com.example.android.domain.usecase

import com.example.android.domain.model.Country
import com.example.android.domain.repository.CountryRepository
import io.reactivex.Single
import javax.inject.Inject

class RetrieveCountryByName @Inject constructor(
    private val countryRepository: CountryRepository
) : SingleParametrizedUseCase<Country, RetrieveCountryByName.Params>() {

    override fun build(params: Params): Single<Country> {
        return countryRepository.loadCountryByName(params.countryName)
    }

    data class Params(val countryName: String)
}