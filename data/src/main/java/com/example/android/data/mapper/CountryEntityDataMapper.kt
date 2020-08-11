package com.example.android.data.mapper

import com.example.android.data.entity.CountryEntity
import com.example.android.data.exception.MappingException
import com.example.android.domain.model.Country
import dagger.Reusable
import javax.inject.Inject

@Reusable
class CountryEntityDataMapper @Inject constructor() {
    fun transformEntity(countryEntity: CountryEntity): Country =
        try {
            Country(
                countryEntity.name,
                countryEntity.alpha2Code,
                countryEntity.nativeName,
                countryEntity.region,
                countryEntity.subRegion,
                countryEntity.latitude,
                countryEntity.longitude,
                countryEntity.area,
                countryEntity.nativeLanguage,
                countryEntity.currencyName,
                countryEntity.currencySymbol,
                countryEntity.flagUrl
            )
        } catch (e: Exception) {
            throw MappingException()
        }

    fun transformToEntity(country: Country): CountryEntity =
        try {
            CountryEntity(
                country.name,
                country.alpha2Code,
                country.nativeName,
                country.region,
                country.subRegion,
                country.latitude,
                country.longitude,
                country.area,
                country.nativeLanguage,
                country.currencyName,
                country.currencySymbol,
                country.flagUrl
            )
        } catch (e: Exception) {
            throw MappingException()
        }

    fun transformEntityList(countryEntities: List<CountryEntity>): List<Country> =
        countryEntities.mapNotNull {
            try {
                transformEntity(it)
            } catch (e: Exception) {
                null
            }
        }

    fun transformToEntityList(countries: List<Country>): List<CountryEntity> =
        countries.mapNotNull {
            try {
                transformToEntity(it)
            } catch (e: Exception) {
                null
            }
        }
}