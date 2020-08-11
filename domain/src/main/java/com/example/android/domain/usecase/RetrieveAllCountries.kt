package com.example.android.domain.usecase

import com.example.android.domain.model.Country
import com.example.android.domain.repository.CountryRepository
import io.reactivex.Single
import javax.inject.Inject

class RetrieveAllCountries @Inject constructor(
    private val countryRepository: CountryRepository
) : SingleUseCase<List<Country>>() {

    override fun build(): Single<List<Country>> {
        return countryRepository.loadAllCountries()
    }
}