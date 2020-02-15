package com.example.cleanskeleton.di.module.activity.screens

import android.app.Activity
import com.example.cleanskeleton.presentation.main.MainActivity
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun mainActivity(activity: MainActivity): Activity

}