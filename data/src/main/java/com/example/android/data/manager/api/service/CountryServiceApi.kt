package com.example.android.data.manager.api.service

import com.example.android.data.entity.remote.ResponseRemoteEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryServiceApi {

    @GET("v1/Country/getCountries")
    fun getCountryFromName(
        @Query("pName") name: String
    ): Single<ResponseRemoteEntity>

    @GET("v1/Country/getCountries")
    fun getAllCountries(): Single<ResponseRemoteEntity>
}