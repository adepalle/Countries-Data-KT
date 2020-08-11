package com.example.android.data.di.module

import com.example.android.data.executor.JobExecutor
import com.example.android.data.repository.CountryRepositoryImpl
import com.example.android.domain.executor.ThreadExecutor
import com.example.android.domain.repository.CountryRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideJobExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    @Singleton
    fun provideRepository(countryRepositoryImpl: CountryRepositoryImpl): CountryRepository =
        countryRepositoryImpl
}