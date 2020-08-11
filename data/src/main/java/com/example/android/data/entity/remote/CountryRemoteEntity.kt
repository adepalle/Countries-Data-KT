package com.example.android.data.entity.remote

import com.google.gson.annotations.SerializedName

data class CountryRemoteEntity(
    @SerializedName("Name")
    val name: String,
    @SerializedName("Alpha2Code")
    val alpha2Code: String,
    @SerializedName("NativeName")
    val nativeName: String,
    @SerializedName("Region")
    val region: String,
    @SerializedName("SubRegion")
    val subRegion: String,
    @SerializedName("Latitude")
    val latitude: String,
    @SerializedName("Longitude")
    val longitude: String,
    @SerializedName("Area")
    val area: Int,
    @SerializedName("NativeLanguage")
    val nativeLanguage: String,
    @SerializedName("CurrencyName")
    val currencyName: String,
    @SerializedName("CurrencySymbol")
    val currencySymbol: String,
    @SerializedName("FlagPng")
    val flagUrl: String
)