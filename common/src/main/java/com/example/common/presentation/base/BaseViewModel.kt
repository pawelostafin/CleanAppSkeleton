package com.example.common.presentation.base

import androidx.lifecycle.ViewModel
import com.example.common.navigator.ScreenNavigator
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var screenNavigator: ScreenNavigator

    protected val disposables: CompositeDisposable = CompositeDisposable()

    private var isViewInitialized = false

    abstract fun onViewInitialized()

    fun viewInitialized() {
        if (!isViewInitialized) {
            onViewInitialized()
        }
        isViewInitialized = true
    }

    fun backButtonClicked() {
        screenNavigator.navigateBack()
    }

}