package com.example.android.data.di.module

import com.example.android.data.manager.api.ApiManager
import com.example.android.data.manager.api.ApiManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ManagerModule {
    @Binds
    @Singleton
    abstract fun provideApiManager(apiManagerImpl: ApiManagerImpl): ApiManager
}