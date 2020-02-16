package com.example.cleanskeleton.framework

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import com.example.cleanskeleton.BuildConfig
import com.example.cleanskeleton.di.component.DaggerAppComponent
import com.example.cleanskeleton.presentation.main.MainActivity
import com.example.cleanskeleton.presentation.second.SecondActivity
import com.example.common.navigator.ScreenNavigator
import com.example.common.navigator.ScreenNavigatorDelegate
import com.jakewharton.threetenabp.AndroidThreeTen
import com.kissdigital.parlorsocial.handler.CurrentActivityProvider
import com.kissdigital.parlorsocial.handler.OnCurrentActivityChangedListener
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import java.lang.ref.WeakReference
import javax.inject.Inject

class CleanAppSkeletonApplication : DaggerApplication(), ScreenNavigatorDelegate, LifecycleObserver {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)

    @Inject
    lateinit var screenNavigator: ScreenNavigator

    private var currentActivity: WeakReference<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        screenNavigator.delegate = this

        initializeTimber()
        AndroidThreeTen.init(this)
        setupCurrentActivityChangedListener()
    }

    private fun setupCurrentActivityChangedListener() {
        val currentActivityProvider = CurrentActivityProvider(
            object : OnCurrentActivityChangedListener {
                override fun onCurrentActivityChanged(activity: Activity) {
                    currentActivity = WeakReference(activity as AppCompatActivity)
                }
            }
        )

        registerActivityLifecycleCallbacks(currentActivityProvider)
    }

    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun onNavigateTo(screen: ScreenNavigator.Screen) {
        val currentActivity = currentActivity?.get() ?: error("cannot navigate without current activity")
        when (screen) {
            is ScreenNavigator.Screen.SecondActivity -> SecondActivity.start(currentActivity, screen.noteId)
            is ScreenNavigator.Screen.MainActivity -> MainActivity.start(currentActivity)
            is ScreenNavigator.Screen.Back -> currentActivity.finish()
        }
    }

}