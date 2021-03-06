package com.example.cleanskeleton.di.component

import com.example.cleanskeleton.di.module.AppModule
import com.example.framework.database.di.DatabaseModule
import com.example.cleanskeleton.di.module.activity.ActivityBindingModule
import com.example.common.di.scope.ApplicationScope
import com.example.cleanskeleton.CleanAppSkeletonApplication
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