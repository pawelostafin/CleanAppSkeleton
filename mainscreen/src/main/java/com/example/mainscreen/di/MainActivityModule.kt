package com.example.mainscreen.di

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.example.common.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun mainActivity(activity: com.example.mainscreen.MainActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(com.example.mainscreen.MainViewModel::class)
    abstract fun mainViewModel(mainViewModel: com.example.mainscreen.MainViewModel): ViewModel

}