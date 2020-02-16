package com.example.secondscreen.di

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.common.di.annotations.ViewModelKey
import com.example.common.di.qualifier.ActivityBundle
import com.example.secondscreen.SecondActivity
import com.example.secondscreen.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class SecondActivityModule {

    @Binds
    abstract fun secondActivity(activity: SecondActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    abstract fun secondViewModel(secondViewModel: SecondViewModel): ViewModel

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideNoteId(@ActivityBundle bundle: Bundle): Long = bundle.getLong(SecondActivity.EXTRA_NOTE_ID)

    }

}