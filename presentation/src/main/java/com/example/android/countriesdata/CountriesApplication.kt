package com.example.android.countriesdata

import android.app.Application
import com.example.android.countriesdata.di.DaggerApplicationComponent
import com.example.android.data.di.DaggerDataComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class CountriesApplication @Inject constructor() : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent
            .builder()
            .application(this)
            .dataComponent(
                DaggerDataComponent.builder().context(this).build()
            )
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}