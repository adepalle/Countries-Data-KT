package com.example.android.data.di

import android.content.Context
import com.example.android.data.di.module.DataModule
import com.example.android.data.di.module.ManagerModule
import com.example.android.data.di.module.NetModule
import com.example.android.domain.executor.ThreadExecutor
import com.example.android.domain.repository.CountryRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        NetModule::class,
        ManagerModule::class,
        DataModule::class
    ]
)
interface DataComponent {

    fun countryRepository(): CountryRepository

    fun threadExecutor(): ThreadExecutor

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        abstract fun context(context: Context): Builder

        abstract fun build(): DataComponent
    }
}