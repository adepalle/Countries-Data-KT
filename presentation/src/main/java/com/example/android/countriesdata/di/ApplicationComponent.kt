package com.example.android.countriesdata.di

import android.app.Application
import com.example.android.countriesdata.CountriesApplication
import com.example.android.countriesdata.di.annotation.PerApplication
import com.example.android.countriesdata.di.module.ActivityInjectorModule
import com.example.android.countriesdata.di.module.ApplicationModule
import com.example.android.countriesdata.di.module.ViewModelModule
import com.example.android.data.di.DataComponent
import com.example.android.domain.executor.ThreadExecutor
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityInjectorModule::class,
        ViewModelModule::class],
    dependencies = [DataComponent::class]
)
interface ApplicationComponent {
    fun inject(app: CountriesApplication)

    fun threadExecutor(): ThreadExecutor

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        abstract fun application(application: Application): Builder
        abstract fun build(): ApplicationComponent
        abstract fun dataComponent(dataComponent: DataComponent): Builder
    }
}