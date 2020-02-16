package com.example.cleanskeleton.presentation.second.di

import android.app.Activity
import com.example.cleanskeleton.presentation.second.SecondActivity
import dagger.Binds
import dagger.Module

@Module
abstract class SecondActivityModule {

    @Binds
    abstract fun secondActivity(activity: SecondActivity): Activity

}