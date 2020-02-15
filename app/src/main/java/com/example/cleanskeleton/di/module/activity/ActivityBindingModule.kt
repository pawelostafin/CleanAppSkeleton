package com.example.cleanskeleton.di.module.activity

import com.example.cleanskeleton.di.module.activity.screens.MainActivityModule
import com.example.cleanskeleton.di.scope.ActivityScope
import com.example.cleanskeleton.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, ActivityModule::class, ActivityViewModelModule::class])
    abstract fun mainActivity(): MainActivity

}