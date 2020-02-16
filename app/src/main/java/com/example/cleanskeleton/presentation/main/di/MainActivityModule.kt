package com.example.cleanskeleton.presentation.main.di

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.example.common.di.annotations.ViewModelKey
import com.example.cleanskeleton.presentation.main.MainActivity
import com.example.cleanskeleton.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun mainActivity(activity: MainActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel

}