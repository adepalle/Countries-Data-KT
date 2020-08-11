package com.example.android.countriesdata.wrapper

import com.example.android.domain.model.Country

data class CountryViewDataWrapper(
    private val country: Country
) {
    fun getCountryName(): String = country.name
    fun getCountryAlpha2Code(): String = country.alpha2Code
    fun getCountryNativeName(): String = country.nativeName
    fun getCountryRegion(): String {
        return "${country.region}/${country.subRegion}"
    }
    fun getCountryLatitude(): String = country.latitude
    fun getCountryLongitude(): String = country.longitude
    fun getCountryArea(): String {
        return "${country.area} m2"
    }
    fun getCountryNativeLanguage(): String = country.nativeLanguage
    fun getCountryCurrency():String {
        return "${country.currencyName}(${country.currencySymbol})"
    }
    fun getCountryFlagUrl(): String = country.flagUrl
}