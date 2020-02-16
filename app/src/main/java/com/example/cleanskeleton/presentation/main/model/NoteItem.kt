package com.example.cleanskeleton.presentation.main.model

data class NoteItem(
    val id: Long?,
    val title: String,
    val message: String,
    val formattedTime: String,
    val formattedDate: String
)
