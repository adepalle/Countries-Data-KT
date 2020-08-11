package com.example.android.countriesdata.di.module

import com.example.android.countriesdata.di.annotation.PerActivity
import com.example.android.countriesdata.di.module.activity.MainModule
import com.example.android.countriesdata.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {
    @PerActivity
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivityInjector(): MainActivity
}