package com.example.cleanskeleton.presentation.splash

import android.os.Bundle
import com.example.common.navigator.ScreenNavigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var screenNavigator: ScreenNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToMainActivity()
    }

    private fun navigateToMainActivity() {
        screenNavigator.navigateToMainScreen()
    }

}
