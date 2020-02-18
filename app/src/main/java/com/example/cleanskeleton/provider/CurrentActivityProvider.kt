package com.kissdigital.parlorsocial.handler

import android.app.Activity
import android.app.Application
import android.os.Bundle
import javax.inject.Inject

class CurrentActivityProvider @Inject constructor(private val currentActivityChangedListener: OnCurrentActivityChangedListener) :
    Application.ActivityLifecycleCallbacks {

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
        currentActivityChangedListener.onCurrentActivityChanged(activity)
    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityDestroyed(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        currentActivityChangedListener.onCurrentActivityChanged(activity)
    }
}