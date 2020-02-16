package com.example.common.navigator

import com.example.common.di.scope.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class ScreenNavigator @Inject constructor() {

    var delegate: ScreenNavigatorDelegate? = null

    fun navigateTo(screen: Screen) {
        delegate?.onNavigateTo(screen)
    }

    sealed class Screen {
        data class SecondActivity(val noteId: Long) : Screen()
        object MainActivity : Screen()
        object Back : Screen()
    }

}