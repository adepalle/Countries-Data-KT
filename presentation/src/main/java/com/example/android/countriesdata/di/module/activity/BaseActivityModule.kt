package com.example.android.countriesdata.di.module.activity

import androidx.fragment.app.FragmentManager
import com.example.android.countriesdata.di.annotation.PerActivity
import com.example.android.countriesdata.ui.BaseActivity
import dagger.Module
import dagger.Provides

@Module
class BaseActivityModule {
    @PerActivity
    @Provides
    fun provideSupportFragmentManager(activity: BaseActivity): FragmentManager {
        return activity.supportFragmentManager
    }
}
