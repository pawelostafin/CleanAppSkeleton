package com.example.cleanskeleton.presentation.splash.di

import android.app.Activity
import com.example.cleanskeleton.presentation.splash.SplashActivity
import dagger.Binds
import dagger.Module

@Module
abstract class SplashActivityModule {

    @Binds
    abstract fun splashActivity(activity: SplashActivity): Activity

}