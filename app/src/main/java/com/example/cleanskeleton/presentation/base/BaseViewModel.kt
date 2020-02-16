package com.example.cleanskeleton.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val disposables: CompositeDisposable = CompositeDisposable()

    private var isViewInitialized = false

    abstract fun onViewInitialized()

    fun viewInitialized() {
        if (!isViewInitialized) {
            onViewInitialized()
        }
        isViewInitialized = true
    }

}