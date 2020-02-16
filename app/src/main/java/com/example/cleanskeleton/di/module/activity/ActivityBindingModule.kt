package com.example.cleanskeleton.di.module.activity

import com.example.cleanskeleton.presentation.main.di.MainActivityModule
import com.example.cleanskeleton.di.scope.ActivityScope
import com.example.cleanskeleton.presentation.main.MainActivity
import com.example.cleanskeleton.presentation.second.SecondActivity
import com.example.cleanskeleton.presentation.second.di.SecondActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, ActivityModule::class])
    abstract fun mainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SecondActivityModule::class, ActivityModule::class])
    abstract fun secondActivity(): SecondActivity

}