package com.example.common.presentation.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseMvvmActivity<T : BaseViewModel> : DaggerAppCompatActivity() {

    abstract val layoutResId: Int
    abstract val viewModelClass: Class<T>

    protected val disposables: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected val viewModel: T by lazy {
        ViewModelProvider(this, viewModelFactory).get(viewModelClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)

        setupView()
        bindUI()
        observeViewModel()
        viewModel.viewInitialized()
    }

    open fun setupView() {}

    open fun bindUI() {}

    open fun observeViewModel() {}

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

}