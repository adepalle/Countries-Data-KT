package com.example.android.countriesdata.di.module.activity

import com.example.android.countriesdata.di.annotation.PerActivity
import com.example.android.countriesdata.di.annotation.PerFragment
import com.example.android.countriesdata.navigator.MainNavigator
import com.example.android.countriesdata.navigator.activity.MainActivityNavigatorListener
import com.example.android.countriesdata.navigator.fragment.CountriesFragmentNavigatorListener
import com.example.android.countriesdata.ui.BaseActivity
import com.example.android.countriesdata.ui.CountriesFragment
import com.example.android.countriesdata.ui.DetailFragment
import com.example.android.countriesdata.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class])
abstract class MainModule {
    @PerActivity
    @Binds
    abstract fun bindBaseActivity(mainActivity: MainActivity): BaseActivity

    @PerFragment
    @ContributesAndroidInjector
    abstract fun countriesFragmentInjector(): CountriesFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun detailFragmentInjector(): DetailFragment

    @PerActivity
    @Binds
    abstract fun mainActivityNavigatorListener(mainNavigator: MainNavigator): MainActivityNavigatorListener

    @PerActivity
    @Binds
    abstract fun countriesFragmentNavigatorListener(mainNavigator: MainNavigator): CountriesFragmentNavigatorListener
}