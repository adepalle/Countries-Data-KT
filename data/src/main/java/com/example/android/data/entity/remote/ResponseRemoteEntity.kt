package com.example.android.data.entity.remote

import com.google.gson.annotations.SerializedName

data class ResponseRemoteEntity(
    @SerializedName("Response")
    val countryEntities: List<CountryRemoteEntity>
)