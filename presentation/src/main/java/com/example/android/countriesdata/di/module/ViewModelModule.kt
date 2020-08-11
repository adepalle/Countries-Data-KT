package com.example.android.countriesdata.di.module

import androidx.lifecycle.ViewModel
import com.example.android.countriesdata.di.annotation.ViewModelKey
import com.example.android.countriesdata.viewmodel.CountriesViewModel
import com.example.android.countriesdata.viewmodel.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CountriesViewModel::class)
    abstract fun bindCountriesViewModel(viewModel: CountriesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel
}