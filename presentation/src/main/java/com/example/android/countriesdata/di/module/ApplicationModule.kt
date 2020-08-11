package com.example.android.countriesdata.di.module

import android.app.Application
import android.content.Context
import com.example.android.countriesdata.di.annotation.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @Provides
    @PerActivity
    fun provideContext(app: Application): Context = app
}