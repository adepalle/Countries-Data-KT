package com.example.android.countriesdata.ui

import android.os.Bundle
import com.example.android.countriesdata.R
import com.example.android.countriesdata.navigator.activity.MainActivityNavigatorListener
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var mainActivityNavigatorListener: MainActivityNavigatorListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        mainActivityNavigatorListener.displayCountriesFragment()
    }
}