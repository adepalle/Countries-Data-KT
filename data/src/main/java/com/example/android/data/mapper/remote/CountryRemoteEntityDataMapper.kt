package com.example.android.data.mapper.remote

import com.example.android.data.entity.CountryEntity
import com.example.android.data.entity.remote.CountryRemoteEntity
import com.example.android.data.exception.MappingException
import dagger.Reusable
import javax.inject.Inject

@Reusable
class CountryRemoteEntityDataMapper @Inject constructor() {
    fun transformRemoteEntity(remoteEntity: CountryRemoteEntity): CountryEntity {
        try {
            return CountryEntity(
                remoteEntity.name,
                remoteEntity.alpha2Code,
                remoteEntity.nativeName,
                remoteEntity.region,
                remoteEntity.subRegion,
                remoteEntity.latitude,
                remoteEntity.longitude,
                remoteEntity.area,
                remoteEntity.nativeLanguage,
                remoteEntity.currencyName,
                remoteEntity.currencySymbol,
                remoteEntity.flagUrl
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }

    fun transformRemoteEntityList(remoteEntities: List<CountryRemoteEntity>): List<CountryEntity> =
        remoteEntities.mapNotNull {
            try {
                transformRemoteEntity(it)
            } catch (e: Exception) {
                null
            }
        }
}