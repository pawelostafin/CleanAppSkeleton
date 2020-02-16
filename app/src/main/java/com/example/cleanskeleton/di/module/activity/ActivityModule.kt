package com.example.cleanskeleton.di.module.activity

import android.app.Activity
import android.os.Bundle
import com.example.cleanskeleton.di.qualifiers.ActivityBundle
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Module
    companion object {

        @JvmStatic
        @ActivityBundle
        @Provides
        fun bundle(activity: Activity): Bundle = activity.intent.extras ?: Bundle.EMPTY

    }
}