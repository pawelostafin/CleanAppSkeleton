package com.example.cleanskeleton.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.cleanskeleton.framework.CleanAppSkeletonApplication
import com.example.cleanskeleton.framework.CleanAppSkeletonViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: CleanAppSkeletonApplication): Context

    @Binds
    abstract fun bindViewModelFactory(factory: CleanAppSkeletonViewModelFactory): ViewModelProvider.Factory

}