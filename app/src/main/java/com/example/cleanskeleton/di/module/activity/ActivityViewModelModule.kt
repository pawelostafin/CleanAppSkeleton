package com.example.cleanskeleton.di.module.activity

import androidx.lifecycle.ViewModel
import com.example.cleanskeleton.di.ViewModelKey
import com.example.cleanskeleton.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel

}