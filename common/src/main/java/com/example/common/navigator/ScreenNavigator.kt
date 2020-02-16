package com.example.common.navigator

import com.example.common.di.scope.ApplicationScope
import com.example.common.navigator.ScreenNavigator.Screen.*
import javax.inject.Inject

@ApplicationScope
class ScreenNavigator @Inject constructor() {

    var delegate: ScreenNavigatorDelegate? = null

    private fun navigateTo(screen: Screen) {
        delegate?.onNavigateTo(screen)
    }

    fun navigateToMainScreen() {
        navigateTo(MainActivity)
    }

    fun navigateToSecondScreen(noteId: Long) {
        navigateTo(SecondActivity(noteId))
    }

    fun navigateBack() {
        navigateTo(Back)
    }

    sealed class Screen {
        data class SecondActivity(val noteId: Long) : Screen()
        object MainActivity : Screen()
        object Back : Screen()
    }

}