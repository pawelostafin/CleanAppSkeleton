package com.example.cleanskeleton.di.module.activity

import com.example.mainscreen.di.MainActivityModule
import com.example.common.di.scope.ActivityScope
import com.example.secondscreen.SecondActivity
import com.example.secondscreen.di.SecondActivityModule
import com.example.cleanskeleton.presentation.splash.SplashActivity
import com.example.cleanskeleton.presentation.splash.di.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashActivityModule::class, ActivityModule::class])
    abstract fun splashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, ActivityModule::class])
    abstract fun mainActivity(): com.example.mainscreen.MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SecondActivityModule::class, ActivityModule::class])
    abstract fun secondActivity(): com.example.secondscreen.SecondActivity

}