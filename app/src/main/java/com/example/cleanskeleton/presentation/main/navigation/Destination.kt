package com.example.cleanskeleton.presentation.main.navigation

sealed class Destination {
    object Back : Destination()
    data class SecondActivity(val noteId: Long) : Destination()
}