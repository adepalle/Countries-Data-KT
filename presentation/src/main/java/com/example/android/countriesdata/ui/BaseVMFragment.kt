package com.example.android.countriesdata.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.countriesdata.viewmodel.ViewModelFactory
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseVMFragment<T : ViewModel> : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: T

    protected abstract val viewModelClass: KClass<T>

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(viewModelClass.java)
        initObservers()
    }

    abstract fun initObservers()

}
