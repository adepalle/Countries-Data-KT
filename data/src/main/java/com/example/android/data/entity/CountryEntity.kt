package com.example.android.data.entity

data class CountryEntity(
    val name: String,
    val alpha2Code: String,
    val nativeName: String,
    val region: String,
    val subRegion: String,
    val latitude: String,
    val longitude: String,
    val area: Int,
    val nativeLanguage: String,
    val currencyName: String,
    val currencySymbol: String,
    val flagUrl: String
)