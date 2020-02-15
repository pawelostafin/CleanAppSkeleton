package com.example.cleanskeleton.di.component

import com.example.cleanskeleton.di.module.AppModule
import com.example.cleanskeleton.di.module.DatabaseModule
import com.example.cleanskeleton.di.module.activity.ActivityBindingModule
import com.example.cleanskeleton.di.scope.ApplicationScope
import com.example.cleanskeleton.framework.CleanAppSkeletonApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent : AndroidInjector<CleanAppSkeletonApplication> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<CleanAppSkeletonApplication>

}